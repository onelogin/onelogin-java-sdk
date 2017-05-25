package com.onelogin.sdk.model;

import org.json.JSONObject;

public class RateLimit {

	protected int limit;
	protected int remaining;
	protected int reset;

	public RateLimit(int limit, int remaining, int reset) {
		this.limit = limit;
		this.remaining = remaining;
		this.reset = reset;
	}

	public RateLimit(JSONObject data) {
		limit = data.optInt("X-RateLimit-Limit");
		remaining = data.optInt("X-RateLimit-Remaining");
		reset = data.optInt("X-RateLimit-Reset");
	}	

	public int getLimit() {
		return limit;
	}

	public int getRemaining() {
		return remaining;
	}

	public int getReset() {
		return reset;
	}
}