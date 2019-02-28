package com.mandelbaum.emailer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Email
{
    @NotNull
    private String name;

    @javax.validation.constraints.Email
    private String email;

    @Min(10)
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
