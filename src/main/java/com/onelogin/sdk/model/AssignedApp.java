package com.onelogin.sdk.model;

import org.json.JSONObject;

public class AssignedApp extends OneLoginResource {
	public long id;
	public String name;
	public String icon;
	
	public AssignedApp(JSONObject data) {
		this.id = data.optLong("id");
		this.name = data.optString("name", null);
		this.icon = data.optString("icon_url", null);	
	}
	
public AssignedApp(long id, String name, String icon_url) {
		this.id = id;
		this.name = name;
		this.icon = icon_url;
	}
}
