package com.onelogin.sdk.model;

import org.json.JSONObject;

public class MFACheckStatus extends OneLoginResource {

	public String id;
	public String status;
	public String deviceId;

	public MFACheckStatus(JSONObject data) {
		id = data.optString("id", null);
		status = data.optString("status", null);
		deviceId = data.optString("device_id", null);
	}
}