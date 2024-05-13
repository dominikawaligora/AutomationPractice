package pages;

import com.microsoft.playwright.Page;

public class HomePage extends PageObject{
    private static final String signInLocator = "a[class=\"login\"]";

    public HomePage(Page page) {
        super(page);
    }

    public HomePage open(String url) {
        page.navigate(url);
        return this;
    }

    public LoginPage clickOnSignIn() {
        page.locator(signInLocator).click();
        return new LoginPage(page);
    }

}
