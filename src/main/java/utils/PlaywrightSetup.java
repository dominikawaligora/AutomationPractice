package utils;

import com.microsoft.playwright.*;

public class PlaywrightSetup {
    private final Playwright playwright;

    public Page getPage() {
        return page;
    }

    private final Page page;
    private BrowserContext browserContext;
    private Browser browser;

    public PlaywrightSetup() {
        playwright = Playwright.create();
        setupBrowserWithContext();
        page = browserContext.newPage();
    }

    private void setupBrowserWithContext() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        browserContext = browser.newContext();
    }


}
