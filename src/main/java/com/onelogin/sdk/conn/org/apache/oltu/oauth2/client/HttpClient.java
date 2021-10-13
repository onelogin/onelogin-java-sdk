/**
 *       Copyright 2010 Newcastle University
 *
 *          http://research.ncl.ac.uk/smart/
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.onelogin.sdk.conn.org.apache.oltu.oauth2.client;

import java.util.Map;

import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthSystemException;

/**
 *
 *
 *
 */
public interface HttpClient {

    public <T extends OAuthClientResponse> T execute(
        OAuthClientRequest request,
        Map<String, String> headers,
        String requestMethod,
        Class<T> responseClass)
        throws OAuthSystemException, OAuthProblemException;
    
    /**
     * Shut down the client and release the resources associated with the HttpClient
     */
    public void shutdown();
}
