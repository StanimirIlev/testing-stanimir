package com.stanimiriliev.mocks.userrepository;

public class UserRepository implements UserDB, Validator {

    public UserRepository(UserDB userDB, Validator validator) {

    }

    public void registerUser(User user) {

    }

    public boolean isAdult(String age) {
        int ages;
        try{
            ages = Integer.parseInt(age);
            return ages > 18;
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean connect() {
        return false;
    }

    @Override
    public boolean validate(String age) {
        return false;
    }
}
