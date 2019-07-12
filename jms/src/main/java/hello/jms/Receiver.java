package hello.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
//定义消息接收者
@Component
public class Receiver {
    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage1(Email email) throws InterruptedException {
      
        if(email.getBody().split(",")[1].equals("20")) {
            System.out.println(email.getBody().split(",")[1]);
        Thread.currentThread().sleep(10000);
        }
        System.out.println("Received2 <" + email + ">");
    }

}