package com.onelogin.sdk.model;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class FactorEnrollmentResponse {

	protected long userId;
	protected long deviceId;
	protected Boolean active;
	protected String authFactorName;
	protected String typeDisplayName;
	protected String userDisplayName;
	protected String stateToken;

	public FactorEnrollmentResponse(JSONObject data) {
		userId = data.optLong("id");
		deviceId = data.optLong("device_id");
		active = data.optBoolean("active", false);
		authFactorName = data.optString("auth_factor_name", null);
		typeDisplayName = data.optString("type_display_name", null);
		userDisplayName = data.optString("user_display_name", null);
		stateToken = data.optString("state_token", null);
	}

	public long getUserID() {
		return userId;
	}

	public long getDeviceID() {
		return deviceId;
	}

	public String getStateToken() {
		return stateToken;
	}

	public Boolean isActive() {
		return active;
	}

	public Map<String, Object> getFactorInfo() {
		Map<String, Object> factorInfo = new HashMap<String, Object>();
		factorInfo.put("active", active);
		factorInfo.put("stateToken", stateToken);
		factorInfo.put("authFactorName", authFactorName);
		factorInfo.put("typeDisplayName", typeDisplayName);
		factorInfo.put("userDisplayName", userDisplayName);
		return factorInfo;
	}
}
