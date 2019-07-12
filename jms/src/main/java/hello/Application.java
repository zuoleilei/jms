package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import hello.activemq.IMessageProducerService;
import hello.activemq.MessageProducerServiceImpl;
import hello.jms.Email;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        jms(context);
        amq(context);

    }

    public static void jms(ConfigurableApplicationContext context) {
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        for (int i = 0; i < 100; i++) {
            jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello," + i));
        }
        System.out.println("wanla wanla");
    }

    public static void amq(ConfigurableApplicationContext context) {

        IMessageProducerService ips = context.getBean(MessageProducerServiceImpl.class);
        ips.sendMessage("队列发送");
        for (int i = 0; i < 100; i++) {
            ips.sendMessage2("订阅发送" + i);

        }
        System.out.println("wanla wanla");

    }

}