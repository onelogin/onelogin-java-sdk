

# Schema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** | Apps unique ID in OneLogin. |  [optional] |
|**connectorId** | **Integer** | ID of the apps underlying connector. |  [optional] |
|**name** | **String** | App name. |  [optional] |
|**description** | **String** | Freeform description of the app. |  [optional] |
|**notes** | **String** | Freeform notes about the app. |  [optional] |
|**policyId** | **Integer** | The security policy assigned to the app. |  [optional] |
|**brandId** | **Integer** | The custom login page branding to use for this app. Applies to app initiated logins via OIDC or SAML. |  [optional] |
|**iconUrl** | **String** | A link to the apps icon url. |  [optional] |
|**visible** | **Boolean** | Indicates if the app is visible in the OneLogin portal. |  [optional] |
|**authMethod** | [**AuthMethodEnum**](#AuthMethodEnum) | An ID indicating the type of app. |  [optional] |
|**tabId** | **Integer** | ID of the OneLogin portal tab that the app is assigned to. |  [optional] |
|**createdAt** | **String** | The date the app was created. |  [optional] |
|**updatedAt** | **String** | The date the app was last updated. |  [optional] |
|**roleIds** | **List&lt;Integer&gt;** | List of Role IDs that are assigned to the app. On App Create or Update the entire array is replaced with the values provided. |  [optional] |
|**allowAssumedSignin** | **Boolean** | Indicates whether or not administrators can access the app as a user that they have assumed control over. |  [optional] |
|**provisioning** | [**SchemaProvisioning**](SchemaProvisioning.md) |  |  [optional] |
|**sso** | **Object** |  |  [optional] |
|**_configuration** | **Object** |  |  [optional] |
|**parameters** | **Object** |  |  [optional] |
|**enforcementPoint** | **Object** |  |  [optional] |



## Enum: AuthMethodEnum

| Name | Value |
|---- | -----|
| NUMBER_0 | 0 |
| NUMBER_1 | 1 |
| NUMBER_2 | 2 |
| NUMBER_3 | 3 |
| NUMBER_4 | 4 |
| NUMBER_6 | 6 |
| NUMBER_7 | 7 |
| NUMBER_8 | 8 |



