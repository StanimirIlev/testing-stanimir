package com.stanimiriliev.mocks.filter;

//import com.stanimiriliev.javaobjects.sumator.Sumator;
//import org.jmock.Expectations;
//import org.jmock.Mockery;
//import org.jmock.auto.Mock;
//import org.junit.jupiter.api.Test;

/**
 * @author Stanimir Iliev
 * @since 17.08.2017
 */
public class FilterTest {

    public interface Endpoint {
        boolean matches(String url);
    }

    public class EndpointFilter {
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
}
