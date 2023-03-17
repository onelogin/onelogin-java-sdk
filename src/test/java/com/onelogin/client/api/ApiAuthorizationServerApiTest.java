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
import com.onelogin.client.model.AltErr;
import com.onelogin.client.model.AuthServer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApiAuthorizationServerApi
 */
@Disabled
public class ApiAuthorizationServerApiTest {

    private final ApiAuthorizationServerApi api = new ApiAuthorizationServerApi();

    /**
     * Create Api Auth Server
     *
     * Create Auth Server
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createAuthServerTest() throws ApiException {
        String contentType = null;
        AuthServer authServer = null;
        AuthServer response = api.createAuthServer(contentType, authServer);
        // TODO: test validations
    }

    /**
     * Delete Api Auth Server
     *
     * Delete Authentication Server
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteAuthServerTest() throws ApiException {
        String apiAuthId = null;
        String contentType = null;
        api.deleteAuthServer(apiAuthId, contentType);
        // TODO: test validations
    }

    /**
     * Get Api Auth Server
     *
     * Get Authorization Server
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAuthServerTest() throws ApiException {
        String apiAuthId = null;
        String contentType = null;
        AuthServer response = api.getAuthServer(apiAuthId, contentType);
        // TODO: test validations
    }

    /**
     * List Api Auth Servers
     *
     * List Authorization Servers
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listAuthServersTest() throws ApiException {
        List<AuthServer> response = api.listAuthServers();
        // TODO: test validations
    }

    /**
     * Update Api Auth Server
     *
     * Update Authorization Server
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateAuthServerTest() throws ApiException {
        String apiAuthId = null;
        String contentType = null;
        AuthServer authServer = null;
        AuthServer response = api.updateAuthServer(apiAuthId, contentType, authServer);
        // TODO: test validations
    }

}