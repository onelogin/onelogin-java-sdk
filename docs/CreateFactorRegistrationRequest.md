

# CreateFactorRegistrationRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**factorId** | **Integer** | The identifier of the factor to enroll the user with. See Get Available Factors for a list of possible id values. |  |
|**displayName** | **String** | A name for the users device |  |
|**expiresIn** | **String** | Defaults to 120. Valid values are: 120-900 seconds. |  [optional] |
|**verified** | **Boolean** | Defaults to false. The following factors support verified &#x3D; true as part of the initial registration request: OneLogin SMS, OneLogin Voice, OneLogin Email. When using verified &#x3D; true it is critical that the supported factors have pre-verified values, most likely imported from an existing directory or by the users themselvdes. Factors such as Authenticator and OneLogin Protect do not support verification &#x3D; true as the user interaction is required to verify the factor. |  [optional] |
|**redirectTo** | **String** | Only applies to Email MagicLink factor. Redirects MagicLink success page to specified URL after 2 seconds. Email must already be configured by the user. |  [optional] |
|**customMessage** | **String** | Only applies to SMS factor. A message template that will be sent via SMS. Max length of the message after template items are inserted is 160 characters including the OTP code. SMS must already be configured by the user. The following template variables can be included in the message. - {{otp_code}} - The security code. - {{otp_expiry}} - The number of minutes until the one time code expires. |  [optional] |



