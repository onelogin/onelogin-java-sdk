package com.onelogin.sdk.conn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.token.BasicOAuthToken;
import org.apache.oltu.oauth2.common.token.OAuthToken;
import org.apache.oltu.oauth2.common.utils.JSONUtils;
import org.joda.time.DateTime;
import org.json.JSONObject;

public class OneloginOAuthJSONAccessTokenResponse extends OAuthAccessTokenResponse {

	private static boolean throwOAuthProblemException = true;

	protected void init(String body, String contentType, int responseCode, Map<String, List<String>> headers)
			throws OAuthProblemException {
		setResponseCode(responseCode);
		setBody(body);
		setContentType(contentType);
		setHeaders(headers);

		try {
			validate();
		} catch (OAuthProblemException e) {
			if (throwOAuthProblemException) {
				throw e;
			}
		}
	}

	public String getAccessToken() {
		return getParam("access_token");
	}

	public String getTokenType() {
		return getParam("token_type");
	}

	public Long getExpiresIn() {
		String value = getParam("expires_in");
		return ((value == null) ? null : Long.valueOf(value));
	}

	public String getScope() {
		return getParam("scope");
	}

	public OAuthToken getOAuthToken() {
		return new BasicOAuthToken(getAccessToken(), getTokenType(), getExpiresIn(), getRefreshToken(), getScope());
	}

	public String getRefreshToken() {
		return getParam("refresh_token");
	}

	public String getAccountID() {
		return getParam("account_id");
	}

	public DateTime getCreateAt() {
		String createdAt = getParam("created_at"); 
		return (createdAt == null)? null : DateTime.parse(createdAt);
	}

	public String getError() {
		return getParam("error");
	}

	public String getErrorDescription() {
		return getParam("error_description");
	}

	protected void setBody(String body) throws OAuthProblemException {
		try {
			this.body = body;

			this.parameters = this.transformOLData(JSONUtils.parseJSON(body));
		} catch (Throwable e) {
			throw OAuthProblemException.error("unsupported_response_type",
					"Invalid response! Response body is not application/json encoded or has non expected values");
		}
	}

	protected void setContentType(String contentType) {
		this.contentType = contentType;
	}

	protected void setResponseCode(int code) {
		this.responseCode = code;
	}

	protected Map<String, Object> transformOLData(Map<String, Object> map)
	{
		if (map.keySet().contains("status")) {
			Map<String, Object> newmap = new HashMap<String, Object>();
			JSONObject status = (JSONObject) map.get("status");
			Boolean error = status.getBoolean("error");
			if (error) {
				newmap.put("error", status.get("type"));
				newmap.put("error_description", status.get("message"));
				newmap.put("state", status.get("code"));
				this.setResponseCode((int)status.get("code"));
			} else {
				if (status.optString("type", null) != null) {
					newmap.put("type", status.getString("type"));
				}
				if (status.optString("message", null) != null) {
					newmap.put("message", status.getString("message"));
				}
			}
			return newmap;
		} else {
			return map;
		}
	}

	public static void enableThrowingOAuthProblemException(boolean value) {
		throwOAuthProblemException = value;
	}
}