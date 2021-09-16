package de.foo.bar.greetings;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public abstract class Greeting implements Serializable {
    abstract public String getGreeting();
}
