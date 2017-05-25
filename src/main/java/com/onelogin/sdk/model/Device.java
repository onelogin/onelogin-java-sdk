package com.onelogin.sdk.model;

import org.json.JSONObject;

public class Device {

	protected long id;
	protected String type;

	public Device(long id, String type) {
		this.id = id;
		this.type = type;
	}

	public Device(JSONObject data) {
		id = data.optLong("device_id");
		type = data.optString("device_type", null);
	}

	public long getID() {
		return id;
	}

	public String getType()	{
		return type;
	}	
}