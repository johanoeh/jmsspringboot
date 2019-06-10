package com.sundsvall.midalva.jms;

import com.sundsvall.midalva.jms.model.Message;
import com.sundsvall.midalva.jms.model.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    MessageSender messageSender;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    CommandLineRunner commandLineRunner(){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0; i <1000 ; i++) {
                    Message message = new Message();
                    message.setId((long) i);
                    message.setMessage("Message no: "+i);

                    messageSender.send(message);
                }

            }
        };
    }
}
