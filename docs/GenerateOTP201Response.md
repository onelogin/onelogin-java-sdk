

# GenerateOTP201Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**mfaToken** | **String** | Token can function as a temporary MFA token. It can be used to authenticate for any app when valid. |  [optional] |
|**reusable** | **Boolean** | true indcates the token can be used multiple times, until it expires. false indicates the token is invalid after a single use or once it expires. Defaults to false. |  [optional] |
|**expiresAt** | **String** | Defines the expiration time and date for the token. Format is UTC time. |  [optional] |
|**deviceId** | **String** | A unique identifier for the temp otp device that has been created for this token. |  [optional] |



