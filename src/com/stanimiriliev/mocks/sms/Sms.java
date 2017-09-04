package com.stanimiriliev.mocks.sms;

import java.util.*;

public class Sms implements SmsValidator{

    public final String text;
    public final String topic;
    public final String receiver;

    public Sms(String receiver, String text, String topic){
        this.text = text;
        this.topic = topic;
        this.receiver = receiver;
    }


    /**
     * Checks if the sms is valid
     * Errors List
     * 0    The receiver of the sms is null
     * 1    The topic of the sms is null
     * 2    The text of the sms is null
     * 3    The receiver of the sms is empty
     * 4    The topic of the sms is empty
     * 5    The text of the sms is empty
     * 6    The receiver of the sms is incorrect
     * 7    The text of the sms is too long
     * 8    Gateway failure
     * @return Sms response with fields 'isSuccessful' and 'errors'
     */
    @Override
    public SmsResponse isValid(){
        List<Integer> errors = new ArrayList<>();
        if(receiver == null){
            errors.add(0);
        }
        else if(receiver.isEmpty()){
            errors.add(3);
        }
        else if(!receiver.startsWith("08") || receiver.length() != 10){
            errors.add(6);
        }
        if(topic == null){
            errors.add(1);
        }
        else if(topic.isEmpty()){
            errors.add(4);
        }
        if(text == null){
            errors.add(2);
        }
        else if(text.isEmpty()) {
            errors.add(5);
        }
        else if(text.length() > 120) {
            errors.add(7);
        }
        if(errors.size() == 0){
            return new SmsResponse(true, null);
        }
        else{
            return new SmsResponse(false, errors);
        }
    }
}
