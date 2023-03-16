

# CreateDeviceVerification201Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**deviceId** | **Integer** | Specifies the factor to be verified. |  [optional] |
|**displayName** | **String** | A name for the users device |  [optional] |
|**expiresAt** | **String** | A short lived token that is required to Verify the Factor. This token expires based on the expires_in parameter passed in. |  [optional] |
|**redirectTo** | **String** | Only applies to Email MagicLink factor. Redirects MagicLink success page to specified URL after 2 seconds. Email must already be configured by the user. |  [optional] |
|**userDisplayName** | **String** | Authentication factor display name assigned by users when they register the device. |  [optional] |
|**id** | **String** | Registration identifier. |  [optional] |
|**typeDisplayName** | **String** | Authentication factor display name as it appears to users upon initial registration, as defined by admins at Settings &gt; Authentication Factors. |  [optional] |
|**authFactorName** | **String** | Authentication factor name, as it appears to administrators in OneLogin. |  [optional] |



