package com.onelogin.sdk.model;

import org.json.JSONObject;

public class OTPDevice {

	public long id;
	public Boolean active;
	public Boolean defaultDevice;
	public String authFactorName;
	public String typeDisplayName;
	public String needsTrigger;
	public String userDisplayName;
	public String stateToken;

	public OTPDevice(JSONObject data) {
		id = data.optLong("id");
		active = data.optBoolean("active", false);
		defaultDevice = data.optBoolean("default", false);
		authFactorName = data.optString("auth_factor_name", null);
		typeDisplayName = data.optString("type_display_name", null);
		userDisplayName = data.optString("user_display_name", null);
		needsTrigger = data.optString("needs_trigger", null);
		stateToken = data.optString("state_token", null);
	}
}