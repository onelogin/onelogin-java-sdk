

# GenerateMFAtoken200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**mfaToken** | **String** | Token can function as a temporary MFA token. It can be used to authenticate for any app when valid. |  [optional] |
|**resuable** | **Boolean** | true indcates the token can be used multiple times, until it expires. false indicates the token is invalid after a single use or once it expires. Defaults to false. |  [optional] |
|**expiresAt** | **String** | Defines the expiration time and date for the token. Format is UTC time. |  [optional] |



