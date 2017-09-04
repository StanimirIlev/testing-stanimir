package com.stanimiriliev.mocks.sms;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class SendSMSMessagesTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void happyPath(){

        SmsGateway smsGateway = context.mock(SmsGateway.class);
        Sms sms = new Sms("0895623156", "dwada", "wdadwa");
        context.checking(new Expectations() {{
            oneOf(smsGateway).send(sms);
            will(returnValue(true));
        }});

        SmsSender sender = new SmsSender(smsGateway);
        sender.send(sms);
    }

    @Test
    public void smsSendFail(){
        SmsGateway smsGateway = context.mock(SmsGateway.class);
        Sms sms = new Sms("0895623156", "dwada", "wdadwa");
        context.checking(new Expectations() {{
            oneOf(smsGateway).send(sms);
            will(returnValue(false));
        }});
        SmsSender sender = new SmsSender(smsGateway);
        sender.send(sms);
    }


    @Test
    public void badSMSWasProvided(){
        SmsGateway smsGateway = context.mock(SmsGateway.class);
        Sms sms = new Sms("0895623156", "", "wdadwa");
        context.checking(new Expectations() {{
            never(smsGateway);
        }});

        SmsSender sender = new SmsSender(smsGateway);
        sender.send(sms);
    }
}