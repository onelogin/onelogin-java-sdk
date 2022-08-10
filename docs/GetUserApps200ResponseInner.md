

# GetUserApps200ResponseInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** | The App ID |  [optional] |
|**iconUrl** | **String** | A url for the icon that represents the app in the OneLogin portal |  [optional] |
|**extension** | **Boolean** | Boolean that indicates if the OneLogin browser extension is required to launch this app. |  [optional] |
|**loginId** | **Integer** | Unqiue identifier for this user and app combination. |  [optional] |
|**name** | **String** | The name of the app. |  [optional] |
|**provisioningStatus** | [**ProvisioningStatusEnum**](#ProvisioningStatusEnum) |  |  [optional] |
|**provisioningState** | [**ProvisioningStateEnum**](#ProvisioningStateEnum) | If provisioning is enabled this indicates the state of provisioning for the given user. |  [optional] |
|**provisioningEnabled** | **Boolean** | Indicates if provisioning is enabled for this app. |  [optional] |



## Enum: ProvisioningStatusEnum

| Name | Value |
|---- | -----|
| ENABLING | &quot;enabling&quot; |
| DISABLING | &quot;disabling&quot; |
| ENABLING_PENDING_APPROVAL | &quot;enabling_pending_approval&quot; |
| DISABLING_PENDDING_APPROVAL | &quot;disabling_pendding_approval&quot; |
| ENABLED | &quot;enabled&quot; |
| DISABLED | &quot;disabled&quot; |
| DISABLING_FAILED | &quot;disabling_failed&quot; |
| ENABLING_FAILED | &quot;enabling_failed&quot; |



## Enum: ProvisioningStateEnum

| Name | Value |
|---- | -----|
| UNKNOWN | &quot;unknown&quot; |
| PROVISIONING | &quot;provisioning&quot; |
| MODIFYING | &quot;modifying&quot; |
| DELETING | &quot;deleting&quot; |
| PROVISIONING_PENDING_APPROVAL | &quot;provisioning_pending_approval&quot; |
| DELETING_PENDING_APPROVAL | &quot;deleting_pending_approval&quot; |
| MODIFYING_PENDING_APPROVAL | &quot;modifying_pending_approval&quot; |
| LINKING | &quot;linking&quot; |
| PROVISIONED | &quot;provisioned&quot; |
| DELETED | &quot;deleted&quot; |
| MODIFYING_FAILED | &quot;modifying_failed&quot; |
| PROVISIONING_FAILED | &quot;provisioning_failed&quot; |
| DELETING_FAILED | &quot;deleting_failed&quot; |
| LINKING_FAILED | &quot;linking_failed&quot; |
| DISABLED | &quot;disabled&quot; |
| NONEXISTENT | &quot;nonexistent&quot; |
| MODIFYING_PENDING_APPROVAL_THEN_DISABLED | &quot;modifying_pending_approval_then_disabled&quot; |



