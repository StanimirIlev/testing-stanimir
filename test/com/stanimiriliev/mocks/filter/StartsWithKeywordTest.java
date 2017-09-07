package com.stanimiriliev.mocks.filter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StartsWithKeywordTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void startsWithKeywordInitializationWithEmptyString(){
        thrown.expect(IllegalArgumentException.class);
        StartsWithKeyword filter = new StartsWithKeyword("");
    }
}