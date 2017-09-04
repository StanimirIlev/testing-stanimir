package com.stanimiriliev.mocks.sms;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        SmsSender sender = new SmsSender(new SmsGateway() {
            @Override
            public boolean send(Sms sms) {
                return true;
            }
        });

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phone: ");
        String receiver = scanner.nextLine();
        System.out.println("Topic: ");
        String topic = scanner.nextLine();
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        SmsResponse result = sender.send(new Sms(receiver,text, topic));
        if (!result.isSuccessful) {
            String[] errors = result.errors;
            List<Integer> erorrsCode = result.errorCode;
            for(int errorCode : erorrsCode){
                System.out.println(errors[errorCode]);
            }
        }
        else{
            System.out.println("The message was sent successfully!");
        }
    }
}
