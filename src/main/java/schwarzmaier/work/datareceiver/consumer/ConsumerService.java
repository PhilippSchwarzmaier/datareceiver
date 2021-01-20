package schwarzmaier.work.datareceiver.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import schwarzmaier.work.datareceiver.importer.model.Message;

@Component
public class ConsumerService {

    private int resquests;

    @JmsListener(destination = "consumer", containerFactory = "myFactory")
    public void consumer(Message message) {
        try {
            if(resquests++%3==0) {
                Thread.sleep(5000);
            }
            System.out.println(resquests+" Received -> "+ message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
