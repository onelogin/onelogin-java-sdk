package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Role extends OneLoginResource {

	protected long id;
	protected String name;
	protected List<Long> userIds;
	protected List<Long> adminIds;
	protected List<Long> appIds;

	public Role(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Role(long id, String name, List<Long> userIds, List<Long> adminIds, List<Long> appIds) {
		this.id = id;
		this.name = name;
		this.userIds = userIds;
		this.adminIds = adminIds;
		this.appIds = appIds;
	}
	
	public Role(JSONObject data) {
		id = data.optLong("id");
		name = data.optString("name", null);
		
		if (data.has("users") && !data.isNull("users")) {
			JSONArray userIdsData = data.getJSONArray("users");
			userIds = new ArrayList<Long>();
			for (int i = 0; i < userIdsData.length(); i++) {
				if (!userIdsData.isNull(i)) {
					userIds.add(userIdsData.getLong(i));
				}
			}
		}

		if (data.has("admins") && !data.isNull("admins")) {
			JSONArray adminIdsData = data.getJSONArray("admins");
			adminIds = new ArrayList<Long>();
			for (int i = 0; i < adminIdsData.length(); i++) {
				if (!adminIdsData.isNull(i)) {
					adminIds.add(adminIdsData.getLong(i));
				}
			}
		}

		if (data.has("apps") && !data.isNull("apps")) {
			JSONArray appIdsData = data.getJSONArray("apps");
			appIds = new ArrayList<Long>();
			for (int i = 0; i < appIdsData.length(); i++) {
				if (!appIdsData.isNull(i)) {
					appIds.add(appIdsData.getLong(i));
				}
			}
		}
	}

	public long getID() {
		return id;
	}

	public String getName()	{
		return name;
	}

	public List<Long> getUserIds() {
		return userIds;
	}

	public List<Long> getAdminIds() {
		return adminIds;
	}

	public List<Long> getAppIds() {
		return appIds;
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