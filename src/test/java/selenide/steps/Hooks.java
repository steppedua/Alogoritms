package selenide.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void start() {
        Configuration.startMaximized = true;
    }
}
