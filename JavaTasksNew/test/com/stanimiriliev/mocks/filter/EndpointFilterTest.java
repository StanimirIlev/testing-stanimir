package com.stanimiriliev.mocks.filter;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class EndpointFilterTest {

    @Test
    void endpointFilterMockTest(){

        Mockery context = new Mockery();

        Endpoint endpointMock = context.mock(Endpoint.class);

        EndpointFilter endpointFilter = new EndpointFilter(endpointMock);
        context.checking(new Expectations(){{
            oneOf(endpointMock).matches("a"); will(returnValue(true));
        }});

        endpointFilter.shouldFilter("a");

        context.assertIsSatisfied();
    }

    @Test
    void startsWithKeywordTest() {
        StartsWithKeyword filter = new StartsWithKeyword();
        EndpointFilter endpointFilter = new EndpointFilter(filter);
        assertTrue(endpointFilter.shouldFilter("keyword"));
        assertTrue(endpointFilter.shouldFilter("keyword21e1 2e dwa"));
        assertFalse(endpointFilter.shouldFilter("jyuy"));
    }
}