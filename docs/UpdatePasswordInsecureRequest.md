

# UpdatePasswordInsecureRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**password** | **String** | Set to the password value using cleartext. Hashes are never stored as cleartext. They are stored securely using cryptographic hash. OneLogin continuously upgrades the strength of the hash. Ensure that the value meets the password strength requirements set for the account. |  |
|**passwordConfirmation** | **String** | Ensure that this value matches the password value exactly. |  |
|**validatePolicy** | **Boolean** | Will passwords validate against the User Policy. Defaults to false. |  [optional] |



