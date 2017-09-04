package com.stanimiriliev.mocks.sms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SmsValidatorTest {

    /**
     *      SmsResponse Errors List
     *
     * 0    The receiver of the sms is null
     * 1    The topic of the sms is null
     * 2    The text of the sms is null
     * 3    The receiver of the sms is empty
     * 4    The topic of the sms is empty
     * 5    The text of the sms is empty
     * 6    The receiver of the sms is incorrect
     * 7    The text of the sms is too long
     * 8    Gateway failure
     */

    @Test
    public void happyPath(){
        Sms sms = new Sms("0895623156", "dwada", "wdadwa");
        SmsResponse expect = new SmsResponse(true, null);
        SmsResponse result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
    }

    @Test
    public void emptyFields(){
        Sms sms = new Sms("", "dwada", "wdadwa");
        SmsResponse expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(3)));
        SmsResponse result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
        sms = new Sms("0895623156", "", "wdadwa");
        expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(5)));
        result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
        sms = new Sms("0895623156", "dwada", "");
        expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(4)));
        result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
    }

    @Test
    public void nullFields(){
        Sms sms = new Sms(null, "dwada", "wdadwa");
        SmsResponse expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(0)));
        SmsResponse result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
        sms = new Sms("0895623156", null, "wdadwa");
        expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(2)));
        result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
        sms = new Sms("0895623156", "dwada", null);
        expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(1)));
        result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
    }

    @Test
    public void longText(){
        Sms sms = new Sms("0895623156", "01234567890123456789012345678901234567890123456789" +
                "01234567890123456789012345678901234567890123456789012345678901234567890123456789", "wdadwa");
        SmsResponse expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(7)));
        SmsResponse result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
    }

    @Test
    public void incorectReceiver(){
        Sms sms = new Sms("089566", "dwada", "wdadwa");
        SmsResponse expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(6)));
        SmsResponse result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
        sms = new Sms("0123456789", "dwada", "wdadwa");
        expect = new SmsResponse(false, new ArrayList<Integer>(Arrays.asList(6)));
        result = sms.isValid();
        assertEquals(expect.isSuccessful, result.isSuccessful);
        assertEquals(expect.errorCode, result.errorCode);
    }
}
