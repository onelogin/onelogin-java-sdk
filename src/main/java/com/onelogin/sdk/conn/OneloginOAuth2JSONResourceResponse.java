package com.onelogin.sdk.conn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import org.apache.oltu.oauth2.client.validator.ResourceValidator;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.utils.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class OneloginOAuth2JSONResourceResponse extends OAuthClientResponse {

	private static boolean throwOAuthProblemException = true;
	
	private JSONArray jsonArray = null;
	private JSONObject jsonObject = null;

	public OneloginOAuth2JSONResourceResponse() {
		this.validator = new ResourceValidator();
	}

	protected void init(String body, String contentType, int responseCode, Map<String, List<String>> headers)
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
		try {
			this.body = body;

			if (!body.isEmpty()) {
				if (body.startsWith("[")) {
					this.jsonArray = new JSONArray(body);
				} else {
					this.jsonObject = new JSONArray("[" + body + "]").getJSONObject(0);
					Map<String, Object> map = JSONUtils.parseJSON(body);
					this.parameters = this.transformOLData(map);
				}
			}
		} catch (Throwable e) {
			throw OAuthProblemException.error("unsupported_response_type",
					"Invalid response! Response body is not application/json encoded or has non expected values");
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

	public Object getFromContent(String name) {
		Object data = null;
		if (this.jsonObject != null && this.jsonObject.has(name)) {
			data = this.jsonObject.get(name);
		}
		return data;
	}

	public JSONObject getJSONObjectFromContent() {
		return this.jsonObject;
	}

	public JSONArray getJSONArrayFromContent() {
		return this.jsonArray;
	}

	public String getBeforeCursor() {
		String value = getParam("before_cursor");
		if (value == "null") {
			return null;
		} else {
			return value;
		}
	}

	public String getAfterCursor() {
		String value = getParam("after_cursor");
		if (value == "null") {
			return null;
		} else {
			return value;
		}
	}

	public String getPreviousLink() {
		return getParam("previous_link");
	}

	public String getNextLink() {
		return getParam("next_link");
	}

	public String getError() {
		return getParam("error");
	}

	public String getErrorDescription() {
		return getParam("error_description");
	}

	public String getErrorAttribute() {
		return getParam("error_attribute");
	}

	public String getType() {
		return getParam("type");
	}

	public String getMessage() {
		return getParam("message");
	}

	protected Map<String, Object> transformOLData(Map<String, Object> map)
	{
		Map<String, Object> newmap = new HashMap<String, Object>();

		if (hadSuccess()) {
			if (map.keySet().contains("beforeCursor")) {
				newmap.put("before_cursor", map.get("beforeCursor"));
			}
			if (map.keySet().contains("previousLink")) {
				newmap.put("previous_link", map.get("previousLink"));
			}
			if (map.keySet().contains("afterCursor")) {
				newmap.put("after_cursor", map.get("afterCursor"));
			}
			if (map.keySet().contains("nextLink")) {
				newmap.put("next_link", map.get("nextLink"));
			}
		} else if (map.keySet().contains("statusCode")) {
			newmap.put("error", map.get("statusCode"));

			if (map.keySet().contains("message")) {
			newmap.put("error_description", map.get("message"));
			} else if (map.keySet().contains("name")) {
				newmap.put("error_description", map.get("name"));
			}
		}

		return newmap;
	}

	public static void enableThrowingOAuthProblemException(boolean value) {
		throwOAuthProblemException = value;
	}
}