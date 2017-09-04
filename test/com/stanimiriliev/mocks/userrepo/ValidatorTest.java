package com.stanimiriliev.mocks.userrepo;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void happyPath(){
        User user = new User("Stanimir", "19");
        Validator validator = context.mock(Validator.class);
        context.checking(new Expectations() {{
            exactly(1).of(validator).isValidAge(user.age);
            will(returnValue(true));
        }});
        assertEquals(true, validator.isValidAge(user.age));
    }

    @Test
    public void emptyAge(){
        User user = new User("Stanimir", "");
        Validator validator = context.mock(Validator.class);
        context.checking(new Expectations() {{
            exactly(1).of(validator).isValidAge(user.age);
            will(returnValue(false));
        }});
        assertEquals(false, validator.isValidAge(user.age));
    }

    @Test
    public void nullAge(){
        User user = new User("Stanimir", "");
        Validator validator = context.mock(Validator.class);
        context.checking(new Expectations() {{
            exactly(1).of(validator).isValidAge(user.age);
            will(returnValue(false));
        }});
        assertEquals(false, validator.isValidAge(user.age));
    }

}