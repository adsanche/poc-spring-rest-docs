package com.capgemini.srd.web.controller;

import com.capgemini.srd.core.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * User REST controller.
 */
@RestController
@RequestMapping(value = "/users", method = RequestMethod.GET)
public class UserController {

    /**
     * Counter for ID generation.
     */
    private AtomicLong counter = new AtomicLong();

    /**
     * Method returning a default user.
     *
     * @return The default user.
     */
    @RequestMapping("/getDefaultUser")
    public User getDefaultUser() {
        final User defaultUser = new User();

        defaultUser.setId(this.counter.incrementAndGet());
        defaultUser.setLogin("adsanche");
        defaultUser.setFirstName("Adrien");
        defaultUser.setLastName("SANCHEZ");

        return defaultUser;
    }
}