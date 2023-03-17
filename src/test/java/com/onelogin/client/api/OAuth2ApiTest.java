/*
 * OneLogin API
 * OpenAPI Specification for OneLogin
 *
 * The version of the OpenAPI document: 3.1.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.onelogin.client.api;

import com.onelogin.client.ApiException;
import com.onelogin.client.model.Error;
import com.onelogin.client.model.GenerateTokenRequest;
import com.onelogin.client.model.GetRateLimit200Response;
import com.onelogin.client.model.OauthToken;
import com.onelogin.client.model.RevokeTokensRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for OAuth2Api
 */
@Disabled
public class OAuth2ApiTest {

    private final OAuth2Api api = new OAuth2Api();

    /**
     * Generate Token
     *
     * Generate Token
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void generateTokenTest() throws ApiException {
        GenerateTokenRequest generateTokenRequest = null;
        String contentType = null;
        OauthToken response = api.generateToken(generateTokenRequest, contentType);
        // TODO: test validations
    }

    /**
     * Get Rate Limit
     *
     * Get Rate Limit
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getRateLimitTest() throws ApiException {
        GetRateLimit200Response response = api.getRateLimit();
        // TODO: test validations
    }

    /**
     * Revoke Tokens
     *
     * Revoke Tokens
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void revokeTokensTest() throws ApiException {
        String contentType = null;
        RevokeTokensRequest revokeTokensRequest = null;
        Error response = api.revokeTokens(contentType, revokeTokensRequest);
        // TODO: test validations
    }

}