

# EnforcementPointResourcesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**path** | **String** |  |  [optional] |
|**isPathRegex** | **Boolean** |  |  [optional] |
|**requireAuth** | **Boolean** |  |  [optional] |
|**permission** | [**PermissionEnum**](#PermissionEnum) |  |  [optional] |
|**conditions** | **String** | required if permission &#x3D;&#x3D; \&quot;conditions\&quot; |  [optional] |



## Enum: PermissionEnum

| Name | Value |
|---- | -----|
| ALLOW | &quot;allow&quot; |
| DENY | &quot;deny&quot; |
| CONDITIONS | &quot;conditions&quot; |



