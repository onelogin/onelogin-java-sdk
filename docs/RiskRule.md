

# RiskRule


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  [optional] |
|**name** | **String** | The name of this rule |  [optional] |
|**description** | **String** |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type parameter specifies the type of rule that will be created. |  [optional] |
|**target** | [**TargetEnum**](#TargetEnum) | The target parameter that will be used when evaluating the rule against an incoming event. |  [optional] |
|**filters** | **List&lt;String&gt;** | A list of IP addresses or country codes or names to evaluate against each event. |  [optional] |
|**source** | [**Source**](Source.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BLACKLIST | &quot;blacklist&quot; |
| WHITELIST | &quot;whitelist&quot; |



## Enum: TargetEnum

| Name | Value |
|---- | -----|
| IP | &quot;location.ip&quot; |
| ADDRESS_COUNTRY_ISO_CODE | &quot;location.address.country_iso_code&quot; |



