package id.ten.belajarspringtransaction.service.impl;

import id.ten.belajarspringtransaction.model.User;
import id.ten.belajarspringtransaction.repository.UserRepository;
import id.ten.belajarspringtransaction.service.MessageService;
import id.ten.belajarspringtransaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageService messageService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String saveUser() {
        String response = "User and Message saved.";
        User user1 = new User("karan", 12000);
        userRepository.save(user1);

//        messageService = null;
        messageService.saveMessage();

        log.info("User saved.");

        return response;
    }

}