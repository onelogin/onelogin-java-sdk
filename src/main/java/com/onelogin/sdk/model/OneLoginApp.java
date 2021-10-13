package com.onelogin.sdk.model;

import org.json.JSONObject;

public class OneLoginApp extends OneLoginResource {

	public long id;
	public long connectorId;
	public String name;
	public Boolean extension;
	public String icon;
	public Boolean visible;
	public Boolean provisioning;

	public OneLoginApp(JSONObject data) {
		id = data.optLong("id");
		connectorId = data.optLong("connector_id");
		name = data.optString("name", null);
		extension = data.optBoolean("extension", false);
		icon = data.optString("icon", null);
		visible = data.optBoolean("visible", false);
		provisioning = data.optBoolean("provisioning", false);
	}
}
