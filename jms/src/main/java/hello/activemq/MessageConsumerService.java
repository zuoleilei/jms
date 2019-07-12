package hello.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {
    @JmsListener(destination="study.msg.queue",containerFactory = "jmsListenerContainerQueue")
    public void receiveMessage(String text) {    // 进行消息接收处理
        System.err.println("【*** 接收消息 ***】" + text);
    }
    
    @JmsListener(destination="study.msg.topic",containerFactory = "jmsListenerContainerTopic")
    public void receiveMessage1(String text) throws InterruptedException {    // 进行消息接收处理
        Thread.currentThread().sleep(500);
        System.err.println("【*** 接收消息 ***】" + text);
    }
    @JmsListener(destination="study.msg.topic",containerFactory = "jmsListenerContainerTopic")
    public void receiveMessage2(String text) throws InterruptedException {    // 进行消息接收处理
        Thread.currentThread().sleep(400);
        System.err.println("【*** 接收消息 ***】" + text);
    }
    
}