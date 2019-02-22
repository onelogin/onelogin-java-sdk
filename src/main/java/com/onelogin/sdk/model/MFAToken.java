package com.onelogin.sdk.model;

import org.joda.time.DateTime;
import org.json.JSONObject;

public class MFAToken {

	public String value;
	public Boolean reusable;
	public DateTime expiresAt;

	public MFAToken(JSONObject data) {
		value = data.optString("mfa_token" , null);
		reusable = data.optBoolean("reusable");
		expiresAt = (data.optString("expires_at" , null) == null)? null : DateTime.parse(data.getString("expires_at"));
	}
}
