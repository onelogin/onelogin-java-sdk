

# CreateSessionLoginToken200ResponseDataInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**expiresAt** | **String** | Date and time when session token expires. Tokens expire 2 minutes after creation. Returned only when MFA is not required. |  [optional] |
|**returnToUrl** | **String** | Returns the return_to_url value sent in the request, if applicable. Returned only when MFA is not required. |  [optional] |
|**sessionToken** | **String** | Provides the session token that can be used to log the user in. Returned only when MFA is not required. |  [optional] |
|**status** | **String** | username_or_email and password values sent are valid. Returned only when MFA is not required. |  [optional] |
|**user** | [**V1User**](V1User.md) |  |  [optional] |
|**stateToken** | **String** | Value to submit with each Verify Factor API call until session login token is issued. Returned only when MFA required. |  [optional] |
|**callbackUrl** | **String** | Verify Factor API endpoint where device_id, state_token, and otp_token must be sent. Returned only when MFA is required. |  [optional] |
|**devices** | [**List&lt;CreateSessionLoginToken200ResponseDataInnerDevicesInner&gt;**](CreateSessionLoginToken200ResponseDataInnerDevicesInner.md) | Provides device values that must be submitted with the Verify Factor API call. Returned only when MFA is required |  [optional] |



