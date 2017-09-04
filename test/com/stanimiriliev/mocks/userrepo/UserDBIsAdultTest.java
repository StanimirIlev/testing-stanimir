package com.stanimiriliev.mocks.userrepo;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDBIsAdultTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void happyPath(){
        UserDB userDB = context.mock(UserDB.class);
        context.checking(new Expectations() {{
            exactly(1).of(userDB).isAdult("Stanimir");
            will(returnValue(true));
        }});
        userDB.isAdult("Stanimir");
    }

    @Test
    public void cantFindThisName(){
        UserDB userDB = context.mock(UserDB.class);
        context.checking(new Expectations() {{
            exactly(1).of(userDB).isAdult("Stanimir");
            will(returnValue(false));
        }});
        userDB.isAdult("Stanimir");
    }

    @Test
    public void isNotAdult(){
        UserDB userDB = context.mock(UserDB.class);
        context.checking(new Expectations() {{
            exactly(1).of(userDB).isAdult("Stanimir");
            will(returnValue(false));
        }});
        userDB.isAdult("Stanimir");
    }

    @Test
    public void errorConnection(){
        UserDB userDB = context.mock(UserDB.class);
        context.checking(new Expectations() {{
            exactly(1).of(userDB).isAdult("Stanimir");
            will(returnValue(false));
        }});
        userDB.isAdult("Stanimir");
    }

}