package su.gild.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import su.gild.constructors.User;
import su.gild.enums.APIEnum;

import java.util.List;

@RestController
@RequestMapping(value = APIEnum.USERS, produces = "application/json")
public class UserController {

    @GetMapping
    public List<User> getUsers() {
        // ...
        return null;
    }

    @GetMapping
    public User getUser(@PathVariable long id) {
        // ...

        return null;
    }
}