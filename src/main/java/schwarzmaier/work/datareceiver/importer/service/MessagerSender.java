package schwarzmaier.work.datareceiver.importer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class MessagerSender {

    @Autowired
    private ConnectionFactory connectionFactory;
    private JmsTemplate jmsTemplate;

    @PostConstruct
    public void init() {
        this.jmsTemplate = new JmsTemplate(connectionFactory);
    }

    public void send(String message){
        System.out.println("Sending an message.");
        jmsTemplate.send("consumer", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

}
