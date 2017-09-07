package com.stanimiriliev.mocks.filter;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndpointFilterTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void oneEndpointFilterThatMatch(){
        Endpoint endpointMock = context.mock(Endpoint.class);

        EndpointFilter endpointFilter = new EndpointFilter(endpointMock);
        context.checking(new Expectations(){{
            exactly(1).of(endpointMock).matches("a"); will(returnValue(true));
        }});
        assertTrue(endpointFilter.shouldFilter("a"));
    }

    @Test
    public void oneEndpointFilterThatNotMatch(){
        Endpoint endpointMock = context.mock(Endpoint.class);

        EndpointFilter endpointFilter = new EndpointFilter(endpointMock);
        context.checking(new Expectations(){{
            exactly(1).of(endpointMock).matches("a"); will(returnValue(false));
        }});
        assertFalse(endpointFilter.shouldFilter("a"));
    }

    @Test
    public void manyEndpointFiltersFirstMatch(){
        Endpoint firstEndpoint = context.mock(Endpoint.class, "firstEndpoint");
        Endpoint secondEndpoint = context.mock(Endpoint.class, "secondEndpoint");
        EndpointFilter endpointFilter = new EndpointFilter(firstEndpoint, secondEndpoint);
        context.checking(new Expectations(){{
            exactly(1).of(firstEndpoint).matches("a");will(returnValue(true));
            exactly(0).of(secondEndpoint).matches("a");
        }});
        assertTrue(endpointFilter.shouldFilter("a"));
    }

    @Test
    public void manyEndpointFiltersLastMatch(){
        Endpoint firstEndpoint = context.mock(Endpoint.class, "firstEndpoint");
        Endpoint secondEndpoint = context.mock(Endpoint.class, "secondEndpoint");
        EndpointFilter endpointFilter = new EndpointFilter(firstEndpoint, secondEndpoint);
        context.checking(new Expectations(){{
            exactly(1).of(firstEndpoint).matches("a");will(returnValue(false));
            exactly(1).of(secondEndpoint).matches("a");will(returnValue(true));
        }});
        assertTrue(endpointFilter.shouldFilter("a"));
    }

    @Test
    public void manyEndpointFiltersNoneMatch(){
        Endpoint firstEndpoint = context.mock(Endpoint.class, "firstEndpoint");
        Endpoint secondEndpoint = context.mock(Endpoint.class, "secondEndpoint");
        EndpointFilter endpointFilter = new EndpointFilter(firstEndpoint, secondEndpoint);
        context.checking(new Expectations(){{
            exactly(1).of(firstEndpoint).matches("a");will(returnValue(false));
            exactly(1).of(secondEndpoint).matches("a");will(returnValue(false));
        }});
        assertFalse(endpointFilter.shouldFilter("a"));
    }

    @Test
    public void noEndpointFilters(){
        EndpointFilter endpointFilter = new EndpointFilter();
        assertFalse(endpointFilter.shouldFilter("a"));
    }
}