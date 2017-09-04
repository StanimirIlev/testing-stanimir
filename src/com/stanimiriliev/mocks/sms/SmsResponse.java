package com.stanimiriliev.mocks.sms;

import java.util.List;

public class SmsResponse {

    public final boolean isSuccessful;
    public final String[] errors = {
            "The receiver of the sms is null.",
            "The topic of the sms is null.",
            "The text of the sms is null.",
            "The receiver of the sms is empty.",
            "The topic of the sms is empty.",
            "The text of the sms is empty.",
            "The receiver of the sms is incorrect. It should be 10 digits and to starts with '08'.",
            "The text of the sms is too long. It should be under 120 characters.",
            "Gateway failure."};
    public final List<Integer> errorCode;

    public SmsResponse(boolean isSuccessful, List<Integer> errorCode){
        this.isSuccessful = isSuccessful;
        this.errorCode = errorCode;
    }

}
