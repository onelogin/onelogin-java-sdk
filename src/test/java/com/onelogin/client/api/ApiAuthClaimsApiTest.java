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
import com.onelogin.client.model.AuthClaim;
import com.onelogin.client.model.AuthId;
import com.onelogin.client.model.TokenClaim;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApiAuthClaimsApi
 */
@Disabled
public class ApiAuthClaimsApiTest {

    private final ApiAuthClaimsApi api = new ApiAuthClaimsApi();

    /**
     * Create Api Auth Server Claim
     *
     * Create Authorization Claim
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createAuthClaimTest() throws ApiException {
        String apiAuthId = null;
        String contentType = null;
        AuthClaim authClaim = null;
        Integer response = api.createAuthClaim(apiAuthId, contentType, authClaim);
        // TODO: test validations
    }

    /**
     * Delete Api Auth Server Claim
     *
     * Delete Authorization Claim
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteAuthClaimTest() throws ApiException {
        String apiAuthId = null;
        Integer claimId = null;
        String contentType = null;
        api.deleteAuthClaim(apiAuthId, claimId, contentType);
        // TODO: test validations
    }

    /**
     * Get Api Auth Server claims
     *
     * Get Authorization claims
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAuthclaimsTest() throws ApiException {
        String apiAuthId = null;
        String contentType = null;
        List<TokenClaim> response = api.getAuthclaims(apiAuthId, contentType);
        // TODO: test validations
    }

    /**
     * Update Api Auth Server Claim
     *
     * Update Authorization Server Claim
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateClaimTest() throws ApiException {
        String apiAuthId = null;
        Integer claimId = null;
        String contentType = null;
        AuthClaim authClaim = null;
        AuthId response = api.updateClaim(apiAuthId, claimId, contentType, authClaim);
        // TODO: test validations
    }

}
