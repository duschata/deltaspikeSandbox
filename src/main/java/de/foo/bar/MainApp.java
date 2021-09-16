package de.foo.bar;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import de.foo.bar.greetings.Greeting;

public class MainApp {
    private MainApp() {
    }

    public static void main(String[] args) {

        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();

        ContextControl contextControl = cdiContainer.getContextControl();
        contextControl.startContext(SessionScoped.class);

        Greeter contextualReference = BeanProvider.getContextualReference(Greeter.class, false);
        List<Greeting> greetings = contextualReference.getGreetings();

        greetings.stream().forEach(greeting -> System.out.println(greeting.getGreeting()));

        cdiContainer.shutdown();

    }
}