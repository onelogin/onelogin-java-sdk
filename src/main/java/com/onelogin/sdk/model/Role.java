package com.onelogin.sdk.model;

import org.json.JSONObject;

public class Role {

	protected long id;
	protected String name;

	public Role(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Role(JSONObject data) {
		id = data.optLong("id");
		name = data.optString("name", null);
	}

	public long getID() {
		return id;
	}

	public String getName()	{
		return name;
	}
}