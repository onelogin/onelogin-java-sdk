

# CreateDeviceVerificationRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**deviceId** | **Integer** | Specifies the factor to be verified. |  |
|**displayName** | **String** | A name for the users device |  [optional] |
|**expiresIn** | **String** | Defaults to 120. Valid values are: 120-900 seconds. |  [optional] |
|**redirectTo** | **String** | Only applies to Email MagicLink factor. Redirects MagicLink success page to specified URL after 2 seconds. Email must already be configured by the user. |  [optional] |
|**customMessage** | **String** | Only applies to SMS factor. A message template that will be sent via SMS. Max length of the message after template items are inserted is 160 characters including the OTP code. SMS must already be configured by the user. The following template variables can be included in the message. - {{otp_code}} - The security code. - {{otp_expiry}} - The number of minutes until the one time code expires. |  [optional] |



