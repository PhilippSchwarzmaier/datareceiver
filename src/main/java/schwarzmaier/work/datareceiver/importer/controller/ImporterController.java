package schwarzmaier.work.datareceiver.importer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import schwarzmaier.work.datareceiver.importer.model.Message;
import schwarzmaier.work.datareceiver.importer.service.MessagerSender;

@RestController
public class ImporterController {

    @Autowired
    private MessagerSender messagerSender;

    @PostMapping("/message")
    public void postMessage(@RequestBody Message message) {
        messagerSender.send(message.getMessage());
    }

    @GetMapping("/message")
    public void getMessage() {
        messagerSender.send("Hello from Rest");
    }

}

