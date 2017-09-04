package com.stanimiriliev.mocks.userrepo;

public interface UserDB {
    boolean isAdult(String name);
    boolean registerUser(User user);
}
