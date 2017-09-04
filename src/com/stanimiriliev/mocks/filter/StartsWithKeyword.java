package com.stanimiriliev.mocks.filter;

public class StartsWithKeyword implements Endpoint{

    private final String keyword;

    public StartsWithKeyword(String keyword){
        this.keyword = keyword;
        if(keyword.isEmpty()){
            throw new IllegalArgumentException("The keyword cannot be a empty string");
        }
    }

    @Override
    public boolean matches(String url) {
        return url.startsWith(keyword);
    }

}
