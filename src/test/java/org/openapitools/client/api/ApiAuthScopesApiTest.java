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


package org.openapitools.client.api;

import com.onelogin.client.ApiException;
import com.onelogin.client.model.AltErr;
import com.onelogin.client.model.AuthId;
import com.onelogin.client.model.AuthScope;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApiAuthScopesApi
 */
@Disabled
public class ApiAuthScopesApiTest {

    private final ApiAuthScopesApi api = new ApiAuthScopesApi();

    /**
     * Create Api Auth Server Scope
     *
     * Create API Auth Server Scope
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createScopeTest() throws ApiException {
        String apiAuthId = null;
        String contentType = null;
        AuthScope authScope = null;
        AuthScope response = api.createScope(apiAuthId, contentType, authScope);
        // TODO: test validations
    }

    /**
     * Delete Api Auth Server Scope
     *
     * Delete Scope
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteScopeTest() throws ApiException {
        String apiAuthId = null;
        Integer scopeId = null;
        String contentType = null;
        api.deleteScope(apiAuthId, scopeId, contentType);
        // TODO: test validations
    }

    /**
     * Get Api Auth Server Scopes
     *
     * List Authorization Scopes
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getScopesTest() throws ApiException {
        String apiAuthId = null;
        String contentType = null;
        List<AuthScope> response = api.getScopes(apiAuthId, contentType);
        // TODO: test validations
    }

    /**
     * Update Api Auth Server Scope
     *
     * Update Scope
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateScopeTest() throws ApiException {
        String apiAuthId = null;
        Integer scopeId = null;
        String contentType = null;
        AuthScope authScope = null;
        AuthId response = api.updateScope(apiAuthId, scopeId, contentType, authScope);
        // TODO: test validations
    }

}
