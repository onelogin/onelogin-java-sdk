

# AppParameters

The parameters section contains parameterized attributes that have defined at the connector level as well as custom attributes that have been defined specifically for this app. Regardless of how they are defined, all parameters have the following attributes. Each parameter is an object with the key for the object being set as the parameters short name.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**userAttributeMappings** | **String** | A user attribute to map values from For custom attributes prefix the name of the attribute with &#x60;custom_attribute_&#x60;. e.g. To get the value for custom attribute &#x60;employee_id&#x60; use &#x60;custom_attribute_employee_id&#x60;. |  [optional] |
|**userAttributeMacros** | **String** | When &#x60;user_attribute_mappings&#x60; is set to &#x60;_macro_&#x60; this macro will be used to assign the parameter value. |  [optional] |
|**label** | **String** | The can only be set when creating a new parameter. It can not be updated. |  [optional] |
|**includeInSamlAssertion** | **Boolean** | When true, this parameter will be included in a SAML assertion payload. |  [optional] |



