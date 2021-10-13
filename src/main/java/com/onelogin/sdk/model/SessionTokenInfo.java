package com.onelogin.sdk.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONObject;

public class SessionTokenInfo extends SessionToken {

	public String status;
	public String returnToUrl;
	public DateTime expiresAt;
	public String sessionToken;

	public SessionTokenInfo(JSONObject data) {
		user = new User(data.getJSONObject("user"));
		status = data.optString("status", null);
		returnToUrl = data.optString("return_to_url", null);
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss Z");
		expiresAt = (data.optString("expires_at", null) == null)? null : DateTime.parse(data.getString("expires_at"), formatter);
		sessionToken = data.optString("session_token", null);
	}

	public String getStatus()	{
		return status;
	}
	
	public DateTime getExpiresAt()	{
		return expiresAt;
	}
	
	public String getSessionToken()	{
		return sessionToken;
	}
}