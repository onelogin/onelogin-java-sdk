

# Hook


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The Hook unique ID in OneLogin. |  [optional] |
|**type** | **String** | A string describing the type of hook. e.g. &#x60;pre-authentication&#x60; |  |
|**disabled** | **Boolean** | Boolean to enable or disable the hook. Disabled hooks will not run. |  |
|**timeout** | **Integer** | The number of seconds to allow the hook function to run before before timing out. Maximum timeout varies based on the type of hook. |  |
|**envVars** | **List&lt;String&gt;** | Environment Variable objects that will be available via process.env.ENV_VAR_NAME in the hook code. |  |
|**runtime** | **String** | The Smart Hooks supported Node.js version to execute this hook with. |  |
|**retries** | **Integer** | Number of retries if execution fails. |  |
|**packages** | **Map&lt;String, String&gt;** | An object containing NPM packages that are bundled with the hook function. |  |
|**function** | **String** | A base64 encoded string containing the javascript function code. |  |
|**contextVersion** | **String** | The semantic version of the content that will be injected into this hook. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | String describing the state of the hook function. When a hook is ready and disabled is false it will be executed. |  [optional] |
|**options** | [**HookOptions**](HookOptions.md) |  |  [optional] |
|**conditions** | [**List&lt;Condition&gt;**](Condition.md) | An array of objects that let you limit the execution of a hook to users in specific roles. |  [optional] |
|**createdAt** | **String** | ISO8601 format date that they hook function was created. |  [optional] |
|**updatedAt** | **String** | ISO8601 format date that they hook function was last updated. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| READY | &quot;ready&quot; |
| CREATE_QUEUED | &quot;create-queued&quot; |
| CREATE_RUNNING | &quot;create-running&quot; |
| CREATE_FAILED | &quot;create-failed&quot; |
| UPDATE_QUEUED | &quot;update-queued&quot; |
| UPDATE_RUNNING | &quot;update-running&quot; |
| UPDATE_FAILED | &quot;update-failed&quot; |



