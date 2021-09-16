package de.foo.bar;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import de.foo.bar.greetings.Greeting;

@ApplicationScoped
public class Greeter {
    public List<Greeting> getGreetings() {
        List<Greeting> greetings = BeanProvider.getContextualReferences(Greeting.class, true);
        return greetings;
    }


}
