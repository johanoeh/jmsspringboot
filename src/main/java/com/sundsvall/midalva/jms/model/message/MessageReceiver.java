package com.sundsvall.midalva.jms.model.message;

import com.sundsvall.midalva.jms.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    @Value("${jms.instanceName}")
    private String instanceName;

    @JmsListener(destination = "message.send", containerFactory = "queueListenerFactory")
    public void receiveMessage(Message message){
        LOG.info("instance {} received message {}",instanceName, message);
    }
}
