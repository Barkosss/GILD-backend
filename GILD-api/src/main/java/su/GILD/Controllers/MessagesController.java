package su.gild.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.gild.constructors.*;
import su.gild.enums.APIEnum;
import su.gild.exceptions.*;
import su.gild.repositories,MemberRepository;
import su.gild.services.AuthorizationService;
import su.gild.services.MessagesService;

import java.util.List;

// ...
@RestController
@RequestMapping(value = APIEnum.MESSAGES, produces = "application/json")
public class MessagesController {
    private final AuthorizationService authorizationService;
    private final MessagesService messagesService;
    Logger logger = LoggerFactory.getLogger(MessagesController.class);

    // ...
    @Autowired
    public MessagesController(AuthorizationService authorizationService, MessagesService messagesService) {
        this.authorizationService = authorizationService;
        this.messagesService = messagesService;
    }

    // ...
    @GetMapping("/")
}