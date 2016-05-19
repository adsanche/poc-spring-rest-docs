package com.capgemini.srd.core.entity;

import lombok.Data;

/**
 * User entity.
 */
@Data
public class User {

    /**
     * User ID.
     */
    private long id;

    /**
     * User login.
     */
    private String login;

    /**
     * User first name.
     */
    private String firstName;

    /**
     * User last name.
     */
    private String lastName;
}