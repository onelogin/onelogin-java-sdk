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
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Group other = (Group) obj;
        if (id != other.id) return false;
        return true;
    }
}