

# GenerateSamlAssertion200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**data** | **String** | Provides the SAML assertion. Returned only when MFA is not required. |  [optional] |
|**message** | **String** | Plain text description describing the outcome of the response. |  [optional] |
|**stateToken** | **String** | State_token that must be submitted with each Verify Factor API call until the SAML assertion has been issued. Returned only if MFA is required. |  [optional] |
|**user** | [**GenerateSamlAssertion200ResponseUser**](GenerateSamlAssertion200ResponseUser.md) |  |  [optional] |
|**devices** | [**List&lt;GenerateSamlAssertion200ResponseDevicesInner&gt;**](GenerateSamlAssertion200ResponseDevicesInner.md) | Provides device values that must be submitted with the Verify Factor API call. Returned only when MFA is required. |  [optional] |
|**callbackUrl** | **String** | Verify Factor API endpoint to which the device_id, state_token, app_id, and otp_token must be sent. Returned only when MFA is required. |  [optional] |



