package com.onelogin.sdk.model;

import org.json.JSONObject;

public class Device extends OneLoginResource {

	protected long id;
	protected String type;
	protected String duoSigRequest;
	protected String duoApiHostname;

	public Device(long id, String type) {
		this.id = id;
		this.type = type;
	}

	public Device(long id, String type, String duoSigRequest, String duoApiHostname) {
		this.id = id;
		this.type = type;
		this.duoSigRequest = duoSigRequest;
		this.duoApiHostname = duoApiHostname;
	}

	public Device(JSONObject data) {
		id = data.optLong("device_id");
		type = data.optString("device_type", null);
		duoSigRequest = data.optString("duo_sig_request", null);
		duoApiHostname = data.optString("duo_api_hostname", null);
	}

	public long getID() {
		return id;
	}

	public String getType()	{
		return type;
	}

	public String getDuoSigRequest() {
		return duoSigRequest;
	}

	public String getDuoApiHostname() {
		return duoApiHostname;
	}
}
