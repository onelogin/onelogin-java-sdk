package com.onelogin.sdk.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.URLConnectionClient;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.response.OAuthClientResponseFactory;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.utils.OAuthUtils;


public class OneloginURLConnectionClient extends URLConnectionClient {
		public <T extends OAuthClientResponse> T execute(OAuthClientRequest request, Map<String, String> headers,
			String requestMethod, Class<T> responseClass) throws OAuthSystemException, OAuthProblemException {
		InputStream responseBody = null;

		Map<String, List<String>> responseHeaders = new HashMap<String, List<String>>();
		URLConnection c;
		int responseCode;
		try {
			URL url = new URL(request.getLocationUri());

			c = url.openConnection();
			responseCode = -1;
			if (c instanceof HttpURLConnection) {
				HttpURLConnection httpURLConnection = (HttpURLConnection) c;

				if ((headers != null) && (!(headers.isEmpty()))) {
					for (Map.Entry<String, String> header : headers.entrySet()) {
						httpURLConnection.addRequestProperty((String) header.getKey(), (String) header.getValue());
					}
				}

				if (request.getHeaders() != null) {
					for (Map.Entry<String, String> header : request.getHeaders().entrySet()) {
						httpURLConnection.addRequestProperty((String) header.getKey(), (String) header.getValue());
					}
				}

				if (OAuthUtils.isEmpty(requestMethod)) {
					httpURLConnection.setRequestMethod("GET");
				} else {
					httpURLConnection.setRequestMethod(requestMethod);
					setRequestBody(request, requestMethod, httpURLConnection);
				}

				httpURLConnection.connect();

				responseCode = httpURLConnection.getResponseCode();
				InputStream inputStream;
				//Modified line to extend the captured errors
				List<Integer> errorCodes=Arrays.asList(400, 401, 403, 404, 422);
				if (errorCodes.contains(responseCode)) {
					inputStream = httpURLConnection.getErrorStream();
				} else {
					inputStream = httpURLConnection.getInputStream();
				}

				responseHeaders = httpURLConnection.getHeaderFields();
				responseBody = inputStream;
			}
		} catch (IOException e) {
			throw new OAuthSystemException(e);
		}

		return (T) OAuthClientResponseFactory.createCustomResponse(responseBody, c.getContentType(), responseCode,
				responseHeaders, responseClass);
	}
	
	private void setRequestBody(OAuthClientRequest request, String requestMethod, HttpURLConnection httpURLConnection)
			throws IOException {
		String requestBody = request.getBody();
		if (OAuthUtils.isEmpty(requestBody)) {
			return;
		}

		if (("POST".equals(requestMethod)) || ("PUT".equals(requestMethod)) || ("DELETE".equals(requestMethod)) ) {
			httpURLConnection.setDoOutput(true);
			OutputStream ost = httpURLConnection.getOutputStream();
			PrintWriter pw = new PrintWriter(ost);
			pw.print(requestBody);
			pw.flush();
			pw.close();
		}
	}
}