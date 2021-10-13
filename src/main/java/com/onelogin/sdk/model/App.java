package com.onelogin.sdk.model;

import org.json.JSONObject;

public class App extends OneLoginResource {

	public long id;
	public String name;
	public String icon;
	public String provisioned;
	public Boolean extension;
	public String loginId;
	public long connectorId;
	public Boolean personal;
	public Boolean visible;
	public JSONObject provisioning;
	public String provisioning_status;
	public String provisioning_state;
	public Boolean provisioning_enabled;

	public App(JSONObject data) {
		id = data.optLong("id");
		name = data.optString("name", null);
		if (data.has("icon")) {
			icon = data.optString("icon", null);
		} else { 
			icon = data.optString("icon_url", null);	
		}
		provisioned = data.optString("provisioned", null);
		extension = data.optBoolean("extension", false);
		loginId = data.optString("login_id");
		connectorId = data.optLong("connector_id");
		if (data.has("personal")) {
			personal = data.optBoolean("personal", false);
		}
		if (data.has("visible")) {
			visible = data.optBoolean("visible", false);
		}
		if (data.has("provisioning")) {
			if (data.get("provisioning") instanceof Boolean) {
				provisioning.put("enabled", data.optBoolean("provisioning"));
			} else {
				provisioning = data.getJSONObject("provisioning");
			}
		}
		if (data.has("provisioning_status")) {
			provisioning_status = data.optString("provisioning_status", null);
		    provisioning_state = data.optString("provisioning_state", null);
		    provisioning_enabled = data.optBoolean("provisioning_enabled", false);
		}
	}
}
