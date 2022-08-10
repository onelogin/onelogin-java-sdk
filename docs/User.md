

# User


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** |  |  [optional] |
|**username** | **String** | A username for the user. |  [optional] |
|**email** | **String** | A valid email for the user. |  [optional] |
|**firstname** | **String** | The user&#39;s first name. |  [optional] |
|**lastname** | **String** | The user&#39;s last name. |  [optional] |
|**title** | **String** | The user&#39;s job title. |  [optional] |
|**department** | **String** | The user&#39;s department. |  [optional] |
|**company** | **String** | The user&#39;s company. |  [optional] |
|**comment** | **String** | Free text related to the user. |  [optional] |
|**groupId** | **Integer** | The ID of the Group in OneLogin that the user is assigned to. |  [optional] |
|**roleIds** | **List&lt;Integer&gt;** | A list of OneLogin Role IDs of the user |  [optional] |
|**phone** | **String** | The E.164 format phone number for a user. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  [optional] |
|**directoryId** | **Integer** | The ID of the OneLogin Directory of the user. |  [optional] |
|**trustedIdpId** | **Integer** | The ID of the OneLogin Trusted IDP of the user. |  [optional] |
|**managerAdId** | **String** | The ID of the user&#39;s manager in Active Directory. |  [optional] |
|**managerUserId** | **String** | The OneLogin User ID for the user&#39;s manager. |  [optional] |
|**samaccountName** | **String** | The user&#39;s Active Directory username. |  [optional] |
|**memberOf** | **String** | The user&#39;s directory membership. |  [optional] |
|**userprincipalname** | **String** | The principle name of the user. |  [optional] |
|**distinguishedName** | **String** | The distinguished name of the user. |  [optional] |
|**externalId** | **String** | The ID of the user in an external directory. |  [optional] |
|**activatedAt** | **String** |  |  [optional] |
|**lastLogin** | **String** |  |  [optional] |
|**invitationSentAt** | **String** |  |  [optional] |
|**updatedAt** | **String** |  |  [optional] |
|**preferredLocaleCode** | **String** |  |  [optional] |
|**createdAt** | **String** |  |  [optional] |
|**customAttributes** | **Object** |  |  [optional] |
|**invalidLoginAttempts** | **Integer** |  |  [optional] |
|**lockedUntil** | **String** |  |  [optional] |
|**passwordChangedAt** | **String** |  |  [optional] |
|**password** | **String** | The password to set for a user. |  [optional] |
|**passwordConfirmation** | **String** | Required if the password is being set. |  [optional] |
|**passwordAlgorithm** | **String** | Use this when importing a password that&#39;s already hashed. Prepend the salt value to the cleartext password value before SHA-256-encoding it |  [optional] |
|**salt** | **String** | The salt value used with the password_algorithm. |  [optional] |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| NUMBER_0 | 0 |
| NUMBER_1 | 1 |
| NUMBER_2 | 2 |
| NUMBER_3 | 3 |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| NUMBER_0 | 0 |
| NUMBER_1 | 1 |
| NUMBER_2 | 2 |
| NUMBER_3 | 3 |
| NUMBER_4 | 4 |
| NUMBER_5 | 5 |
| NUMBER_7 | 7 |
| NUMBER_8 | 8 |



