package de.foo.bar;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Hello {
    public void sayHallo () {
        System.out.println("hello");
    }
}
