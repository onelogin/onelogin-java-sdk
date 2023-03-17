

# ConfigurationOidc


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**loginUrl** | **String** | The OpenId Connect Client Id. Note that client_secret is only returned after Creating an App. |  |
|**redirectUri** | **String** | Comma or newline separated list of valid redirect uris for the OpenId Connect Authorization Code flow. |  |
|**accessTokenExpirationMinutes** | **Integer** | Number of minutes the refresh token will be valid for. |  |
|**refreshTokenExpirationMinutes** | **Integer** | Number of minutes the refresh token will be valid for. |  |
|**tokenEndpointAuthMethod** | [**TokenEndpointAuthMethodEnum**](#TokenEndpointAuthMethodEnum) | - 0: Basic - 1: POST - 2: None / PKCE |  |
|**oidcApplicationType** | [**OidcApplicationTypeEnum**](#OidcApplicationTypeEnum) | - 0 : Web - 1 : Native / Mobile |  |



## Enum: TokenEndpointAuthMethodEnum

| Name | Value |
|---- | -----|
| NUMBER_0 | 0 |
| NUMBER_1 | 1 |
| NUMBER_2 | 2 |



## Enum: OidcApplicationTypeEnum

| Name | Value |
|---- | -----|
| NUMBER_0 | 0 |
| NUMBER_1 | 1 |



