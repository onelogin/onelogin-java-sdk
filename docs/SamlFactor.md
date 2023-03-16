

# SamlFactor


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**appId** | **String** | App ID of the app for which you want to generate a SAML token. This is the app ID in OneLogin. |  |
|**deviceId** | **String** | Provide the MFA device_id you are submitting for verification. The device_id is supplied by the Generate SAML Assertion API. |  |
|**stateToken** | **String** | Provide the state_token associated with the MFA device_id you are submitting for verification. The state_token is supplied by the Generate SAML Assertion API. |  |
|**otpToken** | **String** | Provide the OTP value for the MFA factor you are submitting for verification. For some MFA factors; such as OneLogin OTP SMS, which requires the user to request an OTP; the otp_token value is not required, and if not included, returns a 200 OK - Pending result. You’ll make a subsequent Verify Factor API call to provide the otp_token value once it has been provided to the user. |  [optional] |
|**doNotNotify** | **Boolean** | When verifying MFA via Protect Push, set this to true to stop additional push notifications being sent to the OneLogin Protect device. |  [optional] |



