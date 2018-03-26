package com.onelogin.sdk.model;

import org.json.JSONObject;

public class AuthFactor {

	protected long id;
	protected String name;

	public AuthFactor(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public AuthFactor(JSONObject data) {
		id = data.optLong("factor_id");
		name = data.optString("name", null);
	}

	public long getID() {
		return id;
	}

	public String getName()	{
		return name;
	}
}