package com.onelogin.sdk.model;


public class SAMLEndpointResponse extends OneLoginResource{

	protected String type;
	protected String message;
	protected MFA mfa;
	protected String samlResponse;

	public SAMLEndpointResponse(String type, String message) {
		this.type = type;
		this.message = message;
	}

	public void setMFA(MFA mfa)	{
		this.mfa = mfa;
	}

	public void setSAMLResponse(String samlResponse)	{
		this.samlResponse = samlResponse;
	}

	public String getType()	{
		return type;
	}

	public String getMessage()	{
		return message;
	}

	public MFA getMFA()	{
		return mfa;
	}

	public String getSAMLResponse()	{
		return samlResponse;
	}
}