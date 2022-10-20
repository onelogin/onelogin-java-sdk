

# V1VerifyFactorRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**deviceId** | **String** | Provide the MFA device_id you are submitting for verification. The device_id is supplied by the Create Session Login Token API |  |
|**stateToken** | **String** | Token of MFA device_id you are submitting for verification. The state_token is supplied by the Create Session Login Token API. |  |
|**otpToken** | **String** | Provide the OTP value for the MFA factor you are submitting for verification. |  [optional] |
|**doNotNotify** | **Boolean** | When verifying MFA via Protect Push, true stops additional push notifications being sent to the OneLogin Protect device. |  [optional] |



