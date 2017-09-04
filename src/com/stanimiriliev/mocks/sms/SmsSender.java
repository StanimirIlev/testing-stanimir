package com.stanimiriliev.mocks.sms;

import java.util.ArrayList;
import java.util.List;

public class SmsSender {
    private final SmsGateway gateway;

    public SmsSender(SmsGateway gateway) {
        this.gateway = gateway;
    }

    public SmsResponse send(Sms sms) {
        if (!sms.isValid().isSuccessful) {
            return new SmsResponse(false, sms.isValid().errorCode);
        }
        if (!gateway.send(sms)) {
            List<Integer> errors = new ArrayList<>();
            errors.add(8);
            return new SmsResponse(false, errors);
        }
        return new SmsResponse(true, null);
    }
}
