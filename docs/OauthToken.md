

# OauthToken


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accessToken** | **String** | Provides the requested access token. You can use this token to call our resource APIs. |  [optional] |
|**createdAt** | **String** | Time at which the access token was generated. |  [optional] |
|**expiresIn** | **Integer** | Indicates that the generated access token expires in 36,000 seconds, 600 minutes, or 10 hours. An expired access token cannot be used to make resource API calls, but it can still be used along with its associated refresh token to call the Refresh Tokens v2 API. |  [optional] |
|**refreshToken** | **String** | deprecated No longer in use |  [optional] |
|**tokenType** | **String** | Indicates that the generated access token is a bearer token. |  [optional] |
|**accountId** | **Integer** | Account ID associated with the API credentials used to generate the token. |  [optional] |



