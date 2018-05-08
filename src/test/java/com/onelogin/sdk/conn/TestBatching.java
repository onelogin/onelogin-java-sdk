package com.onelogin.sdk.conn;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.onelogin.sdk.exception.Error;
import com.onelogin.sdk.model.Event;
import com.onelogin.sdk.model.Group;
import com.onelogin.sdk.model.Role;
import com.onelogin.sdk.model.User;

public class TestBatching {
    private static Client client;

    private static final int MAX_RESULTS = 100;
    private static final int BATCH_SIZE = 40;

    @BeforeClass
    public static void beforeClass() throws IOException, Error {
        client = new Client(MAX_RESULTS);
    }

    @Test
    public void testUserBatching() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
        OneLoginResponse<User> batchResponse = client.getUsersBatch(BATCH_SIZE);
        List<User> batchedUsers = new ArrayList<User>();
        while (batchedUsers.size() <= MAX_RESULTS - BATCH_SIZE && batchResponse.getAfterCursor() != null) {
            batchedUsers.addAll(batchResponse.getResults());
            batchResponse = client.getUsersBatch(BATCH_SIZE, batchResponse.getAfterCursor());
        }

        collectRemaining(batchResponse, batchedUsers);
        runBatchingAssertions("user", client.getUsers(), batchedUsers);
    }

    @Test
    public void testEventBatching() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
        OneLoginResponse<Event> batchResponse = client.getEventsBatch(BATCH_SIZE);
        List<Event> batchedEvents = new ArrayList<Event>();
        while (batchedEvents.size() <= MAX_RESULTS - BATCH_SIZE && batchResponse.getAfterCursor() != null) {
            batchedEvents.addAll(batchResponse.getResults());
            batchResponse = client.getEventsBatch(BATCH_SIZE, batchResponse.getAfterCursor());
        }

        collectRemaining(batchResponse, batchedEvents);
        runBatchingAssertions("event", client.getEvents(), batchedEvents);
    }

    @Test
    public void testGroupBatching() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
        OneLoginResponse<Group> batchResponse = client.getGroupsBatch(BATCH_SIZE);
        List<Group> batchedGroups = new ArrayList<Group>();
        while (batchedGroups.size() <= MAX_RESULTS - BATCH_SIZE && batchResponse.getAfterCursor() != null) {
            batchedGroups.addAll(batchResponse.getResults());
            batchResponse = client.getGroupsBatch(BATCH_SIZE, batchResponse.getAfterCursor());
        }

        collectRemaining(batchResponse, batchedGroups);
        runBatchingAssertions("group", client.getGroups(), batchedGroups);
    }

    @Test
    public void testRoleBatching() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
        OneLoginResponse<Role> batchResponse = client.getRolesBatch(BATCH_SIZE);
        List<Role> batchedGroups = new ArrayList<Role>();
        while (batchedGroups.size() <= MAX_RESULTS - BATCH_SIZE && batchResponse.getAfterCursor() != null) {
            batchedGroups.addAll(batchResponse.getResults());
            batchResponse = client.getRolesBatch(BATCH_SIZE, batchResponse.getAfterCursor());
        }
        
        collectRemaining(batchResponse, batchedGroups);
        runBatchingAssertions("roles", client.getRoles(), batchedGroups);
    }

    // ****************
    // Utility methods
    // ****************
    private static <T> void runBatchingAssertions(String entityName, List<T> allEntities, List<T> batchedEntities) {
        Assert.assertEquals("Batched " + entityName + "s count isn't identical to all available " + entityName + "s", allEntities.size(),
                batchedEntities.size());
        for (T entity : allEntities) {
            boolean found = false;
            for (T batchedEntity : batchedEntities) {
                if (batchedEntity.equals(entity)) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue("Batched " + entityName + "s not found in all " + entityName + "s", found);
        }
    }

    private static <T> void collectRemaining(OneLoginResponse<T> batchResponse, List<T> batchedEntities) {
        if (batchResponse.hasResults()) {
            List<T> results = batchResponse.getResults();
            results = results.subList(0, Math.min(results.size(), MAX_RESULTS - batchedEntities.size()));
            batchedEntities.addAll(results);
        }
    }
}
