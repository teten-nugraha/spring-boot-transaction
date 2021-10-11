package id.ten.belajarspringtransaction.service.impl;

import id.ten.belajarspringtransaction.model.Message;
import id.ten.belajarspringtransaction.repository.MessageRepository;
import id.ten.belajarspringtransaction.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public String saveMessage() {
        String response = "Message Saved.";
        Message message = new Message("message for user.");
        messageRepository.save(message);

        log.info(response);

        return response;
    }
}