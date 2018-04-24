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

    public String getName() {
        return name;
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
        Role other = (Role) obj;
        if (id != other.id) return false;
        return true;
    }
}