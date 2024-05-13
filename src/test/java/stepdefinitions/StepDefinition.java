package stepdefinitions;

import com.microsoft.playwright.Page;
import utils.PlaywrightSetup;

public class StepDefinition {
    protected final Page page;

    public StepDefinition(PlaywrightSetup playwrightSetup) {
        this.page = playwrightSetup.getPage();

    }
}
