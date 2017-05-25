package com.onelogin.sdk.model;

import org.joda.time.DateTime;

public class UserMetaData {
	public DateTime activatedAt;
	public DateTime createdAt;
	public DateTime updatedAt;
	public DateTime passwordChangedAt;
	public int invalidLoginAttempts;
	public DateTime invitationSentAt;
	public DateTime lastLogin;
	public DateTime lockedUntil;
}