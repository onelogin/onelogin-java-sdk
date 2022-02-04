package com.onelogin.sdk.model;

import org.json.JSONObject;

public class SmartMFA extends OneLoginResource {
	public long userId;
	public Risk risk;
	public MFAInfo mfa;

	public SmartMFA(long userId, Risk risk, MFAInfo mfa) {
		this.userId = userId;
		this.risk = risk;
		this.mfa = mfa;
	}
	
	public SmartMFA(JSONObject data) {
		userId = data.optLong("userId");
		risk = new Risk(data.getJSONObject("risk"));
		mfa = new MFAInfo(data.getJSONObject("mfa"));
	}	
}