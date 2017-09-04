package com.stanimiriliev.mocks.filter;

public class StartsWithKeyword implements Endpoint{

    @Override
    public boolean matches(String url) {
        return url.startsWith("keyword");
    }

}
