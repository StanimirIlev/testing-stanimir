package com.stanimiriliev.mocks.filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class StartsWithKeywordParameterizedTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{"word", "word12121", true},
                new Object[]{"some", "some", true},
                new Object[]{"word", " word12121", false},
                new Object[]{"some", "Some", false});
    }

    private String keyword;
    private String input;
    private boolean expectation;

    public StartsWithKeywordParameterizedTest(String keyword, String input, boolean expectation){
        this.keyword = keyword;
        this.input = input;
        this.expectation = expectation;
    }

    @Test
    public void startsWithKeywordTest() {
        StartsWithKeyword filter = new StartsWithKeyword(keyword);
        assertEquals(expectation, filter.matches(input));
    }
}
