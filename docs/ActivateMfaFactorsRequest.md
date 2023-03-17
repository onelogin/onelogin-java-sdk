

# ActivateMfaFactorsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**stateTokenExpiresIn** | **Integer** | Optional. Sets the window of time in seconds that the factor must be verified within. Defaults to 120 seconds (2 minutes). Max 900 seconds (15 minutes). |  [optional] |
|**numericSmsOtp** | **Boolean** | Optional. Defaults to false. Only applies to SMS factor. When set to &#x60;true&#x60; a 6 digit numeric code will be sent to the user instead of the standard code which is alphanumeric. |  [optional] |
|**smsMessage** | **String** | Optional. Only applies to SMS factor. A message template that will be sent via SMS. Max length of the message after template items are inserted is 160 characters. The following template variables can be included in the message. - {{otp_code}} - The security code. - {{expiration}} - The number of minutes until the one time code expires. |  [optional] |



