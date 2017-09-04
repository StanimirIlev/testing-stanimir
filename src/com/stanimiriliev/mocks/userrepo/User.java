package com.stanimiriliev.mocks.userrepo;

public class User implements Validator{

    public final String name;
    public final String age;

    public User(String name, String age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean isValidAge(String age) {
        if(age != null && !age.isEmpty() && age.matches("[0-9][0-9]") && Integer.parseInt(age) > 10 &&
                Integer.parseInt(age) < 100){
            return true;
        }
        return false;
    }
}
