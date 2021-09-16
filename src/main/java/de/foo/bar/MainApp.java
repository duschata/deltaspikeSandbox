package de.foo.bar;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;

public class MainApp {
    private MainApp() {
    }

    public static void main(String[] args) {

        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();

        Greeter contextualReference = BeanProvider.getContextualReference(Greeter.class, false);
        contextualReference.greet();

        cdiContainer.shutdown();

    }
}