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
import com.onelogin.client.model.GetInviteLink200Response;
import com.onelogin.client.model.GetInviteLinkRequest;
import com.onelogin.client.model.SendInviteLink200Response;
import com.onelogin.client.model.SendInviteLinkRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for InviteLinksApi
 */
@Disabled
public class InviteLinksApiTest {

    private final InviteLinksApi api = new InviteLinksApi();

    /**
     * Generate Invite Link
     *
     * Generate Invite Link
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getInviteLinkTest() throws ApiException {
        GetInviteLinkRequest getInviteLinkRequest = null;
        GetInviteLink200Response response = api.getInviteLink(getInviteLinkRequest);
        // TODO: test validations
    }

    /**
     * Send  Invite Link
     *
     * Send Invite Link
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void sendInviteLinkTest() throws ApiException {
        SendInviteLinkRequest sendInviteLinkRequest = null;
        SendInviteLink200Response response = api.sendInviteLink(sendInviteLinkRequest);
        // TODO: test validations
    }

}
