package com.onelogin.sdk.model;

import org.json.JSONObject;

public class Group {

	protected long id;
	protected String name;
	protected String reference;

	public Group(long id, String name, String reference) {
		this.id = id;
		this.name = name;
		this.reference = reference;
	}

	public Group(JSONObject data) {
		id = data.optLong("id");
		name = data.optString("name", null);
		reference = data.optString("reference", null);
	}

	public long getID() {
		return id;
	}

	public String getName()	{
		return name;
	}

	public String getReference() {
		return reference;
	}	
}