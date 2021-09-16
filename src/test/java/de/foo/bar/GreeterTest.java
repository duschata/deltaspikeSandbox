package de.foo.bar;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.cdise.weld.WeldContextControl;
import org.apache.deltaspike.core.api.provider.BeanManagerProvider;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.assertj.core.api.Assertions;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.AddExtensions;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import de.foo.bar.greetings.Greeting;

@EnableAutoWeld
@AddBeanClasses({ //
        WeldContextControl.class, //
        Greeter.class //
})

@RunWith(CdiTestRunner.class)
@AddExtensions(BeanManagerProvider.class)
public class GreeterTest {

    @Inject
    private ContextControl contextControl;

    @Inject
    private Greeter greeter;

    @BeforeEach
    public void doFoo() {
        contextControl.stopContexts();
        contextControl.startContext(SessionScoped.class);
    }

    @AfterEach
    public void doBar() {
        contextControl.stopContext(SessionScoped.class);
    }

    @Test
    public void doTest() {
        List<Greeting> greetings = greeter.getGreetings();
        Assertions.assertThat(greetings.size()).isGreaterThan(0);
    }

}