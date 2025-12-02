package com.onelogin.client.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onelogin.client.JSON;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

/**
 * Integration test for GetGroups200Response with pagination field
 */
public class TestGetGroups200ResponseWithPagination {

    @BeforeAll
    public static void setup() {
        // Initialize the JSON helper with Gson configuration
        GsonBuilder builder = JSON.createGson();
        builder.registerTypeAdapterFactory(new GetGroups200Response.CustomTypeAdapterFactory());
        builder.registerTypeAdapterFactory(new GetGroups200ResponsePagination.CustomTypeAdapterFactory());
        Gson gson = builder.create();
        JSON.setGson(gson);
    }

    /**
     * Test that the JSON from the issue can be deserialized successfully
     */
    @Test
    public void testDeserializeJsonWithPagination() throws IOException {
        String jsonString = "{\"status\":{\"error\":false,\"code\":200,\"type\":\"success\",\"message\":\"Success\"},\"pagination\":{\"before_cursor\":null,\"after_cursor\":null,\"previous_link\":null,\"next_link\":null},\"data\":[{\"id\":502836,\"name\":\"test\",\"reference\":null}]}";
        
        // This should not throw an exception anymore
        GetGroups200Response response = GetGroups200Response.fromJson(jsonString);
        
        assertNotNull(response);
        assertNotNull(response.getStatus());
        assertNotNull(response.getPagination());
        assertNotNull(response.getData());
        
        assertEquals(1, response.getData().size());
        assertEquals("test", response.getData().get(0).getName());
        assertEquals(502836, response.getData().get(0).getId());
        
        // Verify pagination object exists
        GetGroups200ResponsePagination pagination = response.getPagination();
        assertNotNull(pagination);
        assertNull(pagination.getBeforeCursor());
        assertNull(pagination.getAfterCursor());
        assertNull(pagination.getPreviousLink());
        assertNull(pagination.getNextLink());
    }
    
    /**
     * Test that the pagination field can have values
     */
    @Test
    public void testDeserializeJsonWithPaginationValues() throws IOException {
        String jsonString = "{\"status\":{\"error\":false,\"code\":200,\"type\":\"success\",\"message\":\"Success\"},\"pagination\":{\"before_cursor\":\"cursor1\",\"after_cursor\":\"cursor2\",\"previous_link\":\"http://prev\",\"next_link\":\"http://next\"},\"data\":[]}";
        
        GetGroups200Response response = GetGroups200Response.fromJson(jsonString);
        
        assertNotNull(response);
        assertNotNull(response.getPagination());
        
        GetGroups200ResponsePagination pagination = response.getPagination();
        assertEquals("cursor1", pagination.getBeforeCursor());
        assertEquals("cursor2", pagination.getAfterCursor());
        assertEquals("http://prev", pagination.getPreviousLink());
        assertEquals("http://next", pagination.getNextLink());
    }
}
