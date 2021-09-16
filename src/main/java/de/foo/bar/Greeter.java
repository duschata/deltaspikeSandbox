package de.foo.bar;

import javax.inject.Inject;

public class Greeter {
    @Inject
    private Hello hello;

    public void greet () {
        hello.sayHallo();
    }
}
