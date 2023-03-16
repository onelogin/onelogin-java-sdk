

# UpdatePasswordSecureRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**password** | **String** | Set to the password value using a SHA-256-encoded value. If you are including your own password_salt value in your request, prepend the salt value to the cleartext password value before SHA-256-encoding it. For example, if your salt value is hello and your cleartext password value is password, the value you need to SHA-256-encode is hellopassword. The resulting encoded value would be b1c788abac15390de987ad17b65ac73c9b475d428a51f245c645a442fddd078b. Note that the alpha characters in this has must all be lower case. |  |
|**passwordConfirmation** | **String** | This value must match the password value. |  |
|**passwordAlgorithm** | **String** | Set to salt+sha256. |  |
|**passwordSalt** | **String** | Optional. If your password hash has been salted then you can provide the salt used in this param. This assumes that the salt was prepended to the password before doing the SHA256 hash. The API supports a salt value that is up to 40 characters long. |  [optional] |



