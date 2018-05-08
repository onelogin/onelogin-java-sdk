package com.onelogin.sdk.conn;

import java.util.List;

/**
 * Holds returned batch of results and the after cursor value required to request the next batch.
 * 
 * @author mgelbana
 *
 * @param <T>
 *            The entity type (User, Event, Group or Role) returned by the getResults method.
 */
public class OneLoginResponse<T> {
    private List<T> results;
    private String afterCursor;

    public OneLoginResponse(List<T> results, String afterCursor) {
        super();
        this.results = results;
        this.afterCursor = afterCursor;
    }

    public List<T> getResults() {
        return results;
    }

    public String getAfterCursor() {
        return afterCursor;
    }

    public boolean hasResults() {
        return this.results != null && !this.results.isEmpty();
    }
}
