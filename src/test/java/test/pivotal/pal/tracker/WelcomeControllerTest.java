package test.pivotal.pal.tracker;

import static org.assertj.core.api.Assertions.assertThat;

import io.pivotal.pal.tracker.WelcomeController;
import org.junit.Test;

public class WelcomeControllerTest {

    @Test
    public void itSaysHello() throws Exception {
        WelcomeController controller = new WelcomeController("A welcome message");

        assertThat(controller.sayHello()).isEqualTo("A welcome message");
    }
}
