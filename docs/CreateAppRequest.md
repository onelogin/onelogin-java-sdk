

# CreateAppRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** | Apps unique ID in OneLogin. |  [optional] [readonly] |
|**name** | **String** | The name of the app. |  |
|**visible** | **Boolean** | Indicates if the app is visible in the OneLogin portal. |  |
|**description** | **String** | Freeform description of the app. |  |
|**notes** | **String** | Freeform notes about the app. |  [optional] |
|**iconUrl** | **String** | A link to the apps icon url |  [optional] |
|**authMethod** | **AuthMethod** |  |  [optional] |
|**policyId** | **Integer** | The security policy assigned to the app. |  |
|**allowAssumedSignin** | **Boolean** | Indicates whether or not administrators can access the app as a user that they have assumed control over. |  [optional] |
|**tabId** | **Integer** | ID of the OneLogin portal tab that the app is assigned to. |  [optional] |
|**connectorId** | **Integer** | ID of the connector to base the app from. |  |
|**createdAt** | **String** | the date the app was created |  [optional] |
|**updatedAt** | **String** | the date the app was last updated |  [optional] |
|**roleIds** | **List&lt;Integer&gt;** | List of Role IDs that are assigned to the app. On App Create or Update the entire array is replaced with the values provided. |  [optional] |
|**provisioning** | [**GenericAppProvisioning**](GenericAppProvisioning.md) |  |  [optional] |
|**parameters** | **AppParameters** |  |  [optional] |
|**enforcementPoint** | [**EnforcementPoint**](EnforcementPoint.md) |  |  [optional] |
|**_configuration** | [**ConfigurationSaml**](ConfigurationSaml.md) |  |  |
|**sso** | [**SsoSaml**](SsoSaml.md) |  |  [optional] |



