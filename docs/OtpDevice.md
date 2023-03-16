

# OtpDevice


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**factorId** | **Integer** | The identifier of the factor to enroll the user with. |  [readonly] |
|**displayName** | **String** | A name for the users device |  |
|**number** | **String** | The phone number of the user in E.164 format. |  |
|**verified** | **Boolean** | Defaults to false. Some factors like SMS or Voice require that a user recieve a token and then that token is supplied to the Verify endpoint before the device is considered active. You can set verfied to &#x60;true&#x60; which indicates the the users phone number is pre verified and the device can be immediately activated.            |  [optional] |



