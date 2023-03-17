

# VerifyMfaFactorRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**stateToken** | **String** | The state_token is returned after a successful request to Enroll a Factor or Activate a Factor. The state_token MUST be provided if the needs_trigger attribute from the proceeding calls is set to true. Note that the state_token expires 120 seconds after creation. If the token is expired you will need to Activate the Factor again. |  [optional] |
|**otpToken** | **String** | OTP code provided by the device or SMS message sent to user. When a device like OneLogin Protect that supports Push has been used you do not need to provide the otp_token and can keep polling this endpoint until the state_token expires. |  [optional] |



