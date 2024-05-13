package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends PageObject {

    private static final String emailInputLocator = "input[id=\"email\"]";
    private static final String newEmailInputLocator = "input[id=\"email_create\"]";
    private static final String passwordInputLocator = "input[id=\"passwd\"]";
    private static final String signInButtonLocator = "button[id=\"SubmitLogin\"]";
    private static final String signOutButtonLocator = "a[class=\"logout\"]";
    private static final String createButtonLocator = "button[id=\"SubmitCreate\"]";
    private static final String customerAccountLocator = "a[class=\"account\"]";

    public LoginPage(Page page) {
        super(page);
    }

    public void enterUserEmail(String email) {
        page.locator(emailInputLocator).fill(email);
    }

    public void enterNewEmail(String email) {
        page.locator(newEmailInputLocator).fill(email);
    }

    public void enterUserPassword(String password) {
        page.locator(passwordInputLocator).fill(password);
    }

    public void clickOnSignInButton() {
        page.locator(signInButtonLocator).click();
    }

    public void clickOnSignOutButton() {
        page.locator(signOutButtonLocator).click();
    }

    public Locator getSignOutButton() {
        return page.locator(signOutButtonLocator);
    }
    public void clickOnCreateButton() {
        page.locator(createButtonLocator).click();
    }


    public Locator getUserName() {
        return page.locator(customerAccountLocator);
    }

    public void logIn(String username, String password) {
        enterUserEmail(username);
        enterUserPassword(password);
        clickOnSignInButton();
    }

    public void createAccount(String userName) {
        enterNewEmail(userName);
        clickOnCreateButton();
    }
    public Locator getLoginError(String errorText) {
        return page.getByText(errorText);
    }


}
