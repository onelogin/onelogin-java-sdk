

# AuthServerConfiguration

Authorization server configuration

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**audiences** | **List&lt;String&gt;** | List of API endpoints that will be returned in Access Tokens. |  |
|**refreshTokenExpirationMinutes** | **Integer** | The number of minutes until refresh token expires. There is no maximum expiry limit. |  [optional] |
|**resourceIdentifier** | **String** | Unique identifier for the API that the Authorization Server will issue Access Tokens for. |  |
|**accessTokenExpirationMinutes** | **Integer** | The number of minutes until access token expires. There is no maximum expiry limit. |  [optional] |



