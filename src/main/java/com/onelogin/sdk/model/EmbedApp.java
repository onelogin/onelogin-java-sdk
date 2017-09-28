package com.onelogin.sdk.model;

import org.json.JSONObject;

public class EmbedApp {

	public long id;
	public String name;
	public String icon;
	public int provisioned;
	public Boolean extensionRequired;
	public int loginId;
	public Boolean personal;

	public EmbedApp(JSONObject data) {
		id = data.optLong("id");
		name = data.optString("name", null);
		icon = data.optString("icon", null);
		provisioned = data.optInt("provisioned");
		extensionRequired = data.optBoolean("extension_required", false);
		loginId = data.optInt("login_id");
		personal = data.optBoolean("personal", false);
	}
}
