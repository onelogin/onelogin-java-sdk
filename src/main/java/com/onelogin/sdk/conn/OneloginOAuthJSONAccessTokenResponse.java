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

			this.parameters = JSONUtils.parseJSON(body);
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

}