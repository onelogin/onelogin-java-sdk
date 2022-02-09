package com.onelogin.sdk.conn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.validator.ResourceValidator;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.utils.JSONUtils;

public class OneloginOAuthBasicResponse extends OAuthClientResponse {

	private static boolean throwOAuthProblemException = true;

	public OneloginOAuthBasicResponse() {
		this.validator = new ResourceValidator();
	}

	public void init(String body, String contentType, int responseCode, Map<String, List<String>> headers)
			throws OAuthProblemException {
		setContentType(contentType);
		setResponseCode(responseCode);
		setBody(body);
		setHeaders(headers);

		try {
			validate();
		} catch (OAuthProblemException e) {
			if (throwOAuthProblemException) {
				throw e;
			}
		}
	}	
	
    protected void validate() throws OAuthProblemException {
        validator.validateParameters(this);
    }

	public String getBody() {
		return this.body;
	}

	public int getResponseCode() {
		return this.responseCode;
	}

	public String getContentType() {
		return this.contentType;
	}
	
	public boolean hadSuccess() {
		return (this.responseCode == 200 || this.responseCode == 201 || this.responseCode == 204); 
	}

	protected void setBody(String body) throws OAuthProblemException {
    this.body = body;

		// In this senario only the errors are known to be parsable as JSON data.
		if (!this.hadSuccess()) {
			try {
				this.parameters = this.transformOLData(JSONUtils.parseJSON(body));
			} catch(Throwable e) {
				throw OAuthProblemException.error("unsupported_response_type",
				"Invalid response! Response body is not application/json encoded or has non expected values");
			}
		}
	}

	public Map<String, List<String>> getHeaders() {
		return this.headers;
	}

	protected void setContentType(String contentType) {
		this.contentType = contentType;
	}

	protected void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getError() {
		return getParam("error");
	}

	public String getErrorDescription() {
		return getParam("error_description");
	}

	protected Map<String, Object> transformOLData(Map<String, Object> map) {
		Map<String, Object> newmap = new HashMap<String, Object>();

		if (!hadSuccess()) {
			if (map.containsKey("message")) {
				newmap.put("error_description", map.get("message"));              
			}
			
			if (map.keySet().contains("name")) {
				newmap.put("error", map.get("name"));                 
			}
		}

		return newmap;
	}

	public static void enableThrowingOAuthProblemException(boolean value) {
		throwOAuthProblemException = value;
	}
}