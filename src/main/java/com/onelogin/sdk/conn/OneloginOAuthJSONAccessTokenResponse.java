package com.onelogin.sdk.conn;

import java.util.HashMap;
import java.util.Map;

import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.token.BasicOAuthToken;
import org.apache.oltu.oauth2.common.token.OAuthToken;
import org.apache.oltu.oauth2.common.utils.JSONUtils;
import org.joda.time.DateTime;
import org.json.JSONObject;

public class OneloginOAuthJSONAccessTokenResponse extends OAuthAccessTokenResponse {
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
		Map<String, Object> newmap = new HashMap<String, Object>();
		if (map.keySet().contains("data")) {
			JSONObject data = (JSONObject) ((Object[])map.get("data"))[0];
			newmap.put("access_token", data.optString("access_token", null));
			newmap.put("refresh_token", data.optString("refresh_token", null));
			newmap.put("expires_in", data.get("expires_in"));
			newmap.put("token_type", data.get("token_type"));
			newmap.put("account_id", data.optInt("account_id"));
			newmap.put("created_at", data.optString("created_at", null));
		}
		if (map.keySet().contains("status")) {
			JSONObject status = (JSONObject) map.get("status");
			Boolean error = status.getBoolean("error");
			if (error) {
				newmap.put("error", status.get("type"));
				newmap.put("error_description", status.get("message"));
				newmap.put("state", status.get("code"));
			}
		}
		return newmap;
	}
}