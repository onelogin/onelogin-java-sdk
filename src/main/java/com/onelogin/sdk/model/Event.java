package com.onelogin.sdk.model;

import org.joda.time.DateTime;
import org.json.JSONObject;

public class Event extends OneLoginResource {

	public long id;
	public DateTime createdAt;
	public int accountId;
	public int userId;
	public String userName;
	public int eventTypeId;
	public String notes;
	public String ipaddr;
	public int actorUserId;
	public String actorUserName;
	public int assumingActingUserId ;
	public int roleId;
	public String roleName;
	public int appId;
	public String appName;
	public int groupId;
	public String groupName;
	public int otpDeviceId;
	public String otpDeviceName;
	public int policyId;
	public String policyName;
	public String actorSystem;
	public String customMessage;
	public String operationName;
	public int directorySyncRunId;
	public int directoryId;
	public String resolution;
	public int clientId;
	public int resourceTypeId;
	public String errorDescription;
	public String proxyIp;
	public int riskScore;
	public String riskReasons;
	public String riskCookieId;
	public String browserFingerprint;

	public Event(JSONObject data) {
		id = data.optLong("id");
		createdAt = (data.optString("created_at", null) == null)? null : DateTime.parse(data.getString("created_at"));
		accountId = data.optInt("account_id");
		userId = data.optInt("user_id");
		userName = data.optString("user_name");
		eventTypeId = data.optInt("event_type_id");
		notes = data.optString("notes", null);
		ipaddr = data.optString("ipaddr", null);
		actorUserId = data.optInt("actor_user_id");
		actorUserName = data.optString("actor_user_name", null);
		assumingActingUserId = data.optInt("assuming_acting_user_id");
		roleId = data.optInt("role_id");
		roleName = data.optString("role_name", null);
		appId = data.optInt("app_id");
		appName = data.optString("app_name", null);
		groupId = data.optInt("group_id");
		groupName = data.optString("group_name", null);
		otpDeviceId = data.optInt("otp_device_id");
		otpDeviceName = data.optString("otp_device_name", null);
		policyId = data.optInt("policy_id");
		policyName = data.optString("policy_name", null);
		actorSystem = data.optString("actor_system", null);
		customMessage = data.optString("custom_message", null);
		operationName = data.optString( "operation_name", null);
		directorySyncRunId = data.optInt("directory_sync_run_id");
		directoryId = data.optInt("directory_id");
		resolution = data.optString("resolution", null);
		clientId = data.optInt("client_id");
		resourceTypeId = data.optInt("resource_type_id");
		errorDescription = data.optString("error_description", null);
		proxyIp = data.optString("proxy_ip", null);
		riskScore = data.optInt("risk_score");;
		riskReasons = data.optString("risk_reasons", null);
		riskCookieId = data.optString("risk_cookie_id", null);
		browserFingerprint = data.optString("browser_fingerprint", null);
	}

	public Role getRole() {
		Role role = null;
		if (roleId != 0 && roleName!= null) {
			role = new Role(roleId, roleName);
		}
		return role;
	}

	public Group getGroup()	{
		Group group = null;
		if (groupId != 0 && groupName!= null) {
			group = new Group(groupId, groupName, null);
		}
		return group;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (groupId ^ (groupId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Event other = (Event) obj;
        if (id != other.id) return false;
        return true;
    }
}