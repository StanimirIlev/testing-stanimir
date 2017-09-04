package com.stanimiriliev.mocks.filter;

//import org.jmock.Mockery;

/**
 * @author Stanimir Iliev
 * @since 17.08.2017
 */

public class EndpointFilter {

    public interface Endpoint {
        boolean matches(String url);
    }

    private final Endpoint[] endpoints;

    public EndpointFilter(Endpoint... endpoints) {
        this.endpoints = endpoints;
    }

    public boolean shouldFilter(String url) {
        for (Endpoint each : endpoints) {
            if (each.matches(url)) {
                return true;
            }
        }
        return false;
    }
}
