package com.stanimiriliev.mocks.filter;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndpointFilterTest {


    Mockery context = new Mockery();

    @Test
    public void oneEndpointFilterThatMatch(){
        Endpoint endpointMock = context.mock(Endpoint.class);

        EndpointFilter endpointFilter = new EndpointFilter(endpointMock);
        context.checking(new Expectations(){{
            exactly(1).of(endpointMock).matches("a"); will(returnValue(true));
        }});
        assertTrue(endpointFilter.shouldFilter("a"));
        context.assertIsSatisfied();
    }

    @Test
    public void oneEndpointFilterThatNotMatch(){
        Endpoint endpointMock = context.mock(Endpoint.class);

        EndpointFilter endpointFilter = new EndpointFilter(endpointMock);
        context.checking(new Expectations(){{
            exactly(1).of(endpointMock).matches("a"); will(returnValue(false));
        }});
        assertFalse(endpointFilter.shouldFilter("a"));
        context.assertIsSatisfied();
    }

    @Test
    public void manyEndpointFiltersFirstMatch(){
        Mockery firstEndpoint = new Mockery();
        Mockery secondEndpoint = new Mockery();
        Endpoint[] endpoints = new Endpoint[2];
        endpoints[0] = firstEndpoint.mock(Endpoint.class);
        endpoints[1] = secondEndpoint.mock(Endpoint.class);
        EndpointFilter endpointFilter = new EndpointFilter(endpoints);
        firstEndpoint.checking(new Expectations(){{
            exactly(1).of(endpoints[0]).matches("a");will(returnValue(true));
        }});
        secondEndpoint.checking(new Expectations(){{
            exactly(0).of(endpoints[1]).matches("a");
        }});
        assertTrue(endpointFilter.shouldFilter("a"));
        firstEndpoint.assertIsSatisfied();
        secondEndpoint.assertIsSatisfied();
    }

    @Test
    public void manyEndpointFiltersLastMatch(){
        Mockery firstEndpoint = new Mockery();
        Mockery secondEndpoint = new Mockery();
        Endpoint[] endpoints = new Endpoint[2];
        endpoints[0] = firstEndpoint.mock(Endpoint.class);
        endpoints[1] = secondEndpoint.mock(Endpoint.class);
        EndpointFilter endpointFilter = new EndpointFilter(endpoints);
        firstEndpoint.checking(new Expectations(){{
            exactly(1).of(endpoints[0]).matches("a");will(returnValue(false));
        }});
        secondEndpoint.checking(new Expectations(){{
            exactly(1).of(endpoints[1]).matches("a");will(returnValue(true));
        }});
        assertTrue(endpointFilter.shouldFilter("a"));
        firstEndpoint.assertIsSatisfied();
        secondEndpoint.assertIsSatisfied();
    }

    @Test
    public void manyEndpointFiltersNoneMatch(){
        Mockery firstEndpoint = new Mockery();
        Mockery secondEndpoint = new Mockery();
        Endpoint[] endpoints = new Endpoint[2];
        endpoints[0] = firstEndpoint.mock(Endpoint.class);
        endpoints[1] = secondEndpoint.mock(Endpoint.class);
        EndpointFilter endpointFilter = new EndpointFilter(endpoints);
        firstEndpoint.checking(new Expectations(){{
            exactly(1).of(endpoints[0]).matches("a");will(returnValue(false));
        }});
        secondEndpoint.checking(new Expectations(){{
            exactly(1).of(endpoints[1]).matches("a");will(returnValue(false));
        }});
        assertFalse(endpointFilter.shouldFilter("a"));
        firstEndpoint.assertIsSatisfied();
        secondEndpoint.assertIsSatisfied();
    }

    @Test
    public void noEndpointFilters(){
        EndpointFilter endpointFilter = new EndpointFilter();
        assertFalse(endpointFilter.shouldFilter("a"));
    }

    @Test
    public void startsWithKeywordTestHappyPath() {
        StartsWithKeyword filter = new StartsWithKeyword("word");
        assertTrue(filter.matches("word"));
        assertTrue(filter.matches("word 2e dwa"));
        assertFalse(filter.matches("jyuy"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void startsWithKeywordInitializationWithEmptyString(){
        StartsWithKeyword filter = new StartsWithKeyword("");
    }
}