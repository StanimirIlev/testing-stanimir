package com.stanimiriliev.mocks.userrepository;

import org.jmock.Mockery;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    @Test
    public void testConnection(){
        Mockery context = new Mockery();
        UserDB userDB = context.mock(UserDB.class);
        Validator validator = context.mock(Validator.class);



        UserRepository userRepository = new UserRepository(userDB, validator);
    }
}