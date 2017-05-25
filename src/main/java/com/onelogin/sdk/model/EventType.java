package com.onelogin.sdk.model;

import org.json.JSONObject;

public class EventType {

	public long id;
	public String name;
	public String description;

	public EventType(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public EventType(JSONObject data) {
		id = data.optLong("id");
		name = data.optString("name", null);
		description = data.optString("description", null);
	}

	public long getID() {
		return id;
	}
	
	public String getName()	{
		return name;
	}

	public String getDescription() {
		return description;
	}
}