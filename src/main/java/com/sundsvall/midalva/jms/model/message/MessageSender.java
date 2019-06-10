package com.sundsvall.midalva.jms.model.message;

import com.sundsvall.midalva.jms.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;

@Configuration
public class MessageSender {

    private final ConfigurableApplicationContext context;

    @Autowired
    public MessageSender(ConfigurableApplicationContext context) {
        this.context = context;
    }

    /**
     *
     * @param message
     */
    public void send(Message message){
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend("message.send", message);
    }
}
