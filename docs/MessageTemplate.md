

# MessageTemplate


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** |  |  [optional] [readonly] |
|**accountId** | **Integer** |  |  [optional] [readonly] |
|**type** | [**TypeEnum**](#TypeEnum) | Template type that describes the source (sms, voice, email) and purpose (registration, invite, etc) |  |
|**locale** | **String** | The 2 character language locale for the template. e.g. en &#x3D; English, es &#x3D; Spanish |  |
|**template** | [**MessageTemplateTemplate**](MessageTemplateTemplate.md) |  |  |
|**templateClass** | **String** |  |  [optional] [readonly] |
|**updatedAt** | **String** | Last time template was updated |  [optional] [readonly] |
|**brandId** | **Integer** | brand id number |  [optional] [readonly] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| EMAIL_FORGOT_PASSWORD | &quot;email_forgot_password&quot; |
| EMAIL_CODE_REGISTRATION | &quot;email_code_registration&quot; |
| EMAIL_CODE_LOGIN_VERIFICATION | &quot;email_code_login_verification&quot; |
| EMAIL_CODE_APP_VERIFICATION | &quot;email_code_app_verification&quot; |
| EMAIL_CODE_PW_RESET_VERIFICATION | &quot;email_code_pw_reset_verification&quot; |
| EMAIL_MAGICLINK_REGISTRATION | &quot;email_magiclink_registration&quot; |
| EMAIL_MAGICLINK_LOGIN_VERIFICATION | &quot;email_magiclink_login_verification&quot; |
| EMAIL_MAGICLINK_APP_VERIFICATION | &quot;email_magiclink_app_verification&quot; |
| EMAIL_MAGICLINK_PW_RESET_VERIFICATION | &quot;email_magiclink_pw_reset_verification&quot; |
| SMS_REGISTRATION | &quot;sms_registration&quot; |
| SMS_LOGIN_VERIFICATION | &quot;sms_login_verification&quot; |
| SMS_APP_VERIFICATION | &quot;sms_app_verification&quot; |
| SMS_PW_RESET_VERIFICATION | &quot;sms_pw_reset_verification&quot; |



