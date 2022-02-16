package com.onelogin.sdk.model;

import org.json.JSONObject;

public class MFAInfo extends OneLoginResource {

	public boolean otpSent;
	public String stateToken;
	
	public MFAInfo(boolean otpSent, String stateToken) {
		this.otpSent = otpSent;
		this.stateToken = stateToken;
	}

	public MFAInfo(JSONObject data) {
		otpSent = data.optBoolean("otp_sent");
		stateToken = data.optString("state_token");
	}
}