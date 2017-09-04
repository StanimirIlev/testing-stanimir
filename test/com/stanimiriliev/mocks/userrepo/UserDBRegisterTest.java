package com.stanimiriliev.mocks.userrepo;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDBRegisterTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void happyPath(){
        User user = new User("Stanimir", "19");
        UserDB userDB = context.mock(UserDB.class);
        context.checking(new Expectations() {{
            exactly(1).of(userDB).registerUser(user);
            will(returnValue(true));
        }});
        userDB.registerUser(user);
    }

    @Test
    public void duplicatedUser(){
        User user = new User("Stanimir", "19");
        UserDB userDB = context.mock(UserDB.class);
        context.checking(new Expectations() {{
            exactly(1).of(userDB).registerUser(user);
            will(returnValue(false));
        }});
        userDB.registerUser(user);
    }

    @Test
    public void errorConnection(){
        User user = new User("Stanimir", "19");
        UserDB userDB = context.mock(UserDB.class);
        context.checking(new Expectations() {{
            exactly(1).of(userDB).registerUser(user);
            will(returnValue(false));
        }});
        userDB.registerUser(user);
    }

    @Test
    public void outOfMemory(){
        User user = new User("Stanimir", "19");
        UserDB userDB = context.mock(UserDB.class);
        context.checking(new Expectations() {{
            exactly(1).of(userDB).registerUser(user);
            will(returnValue(false));
        }});
        userDB.registerUser(user);
    }

}