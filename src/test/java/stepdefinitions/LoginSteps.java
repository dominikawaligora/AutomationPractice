package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.Credentials;
import utils.PlaywrightSetup;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.Properties.*;

public class LoginSteps extends StepDefinition {
    HomePage homePage;
    LoginPage loginPage;

    public LoginSteps() {
        super(new PlaywrightSetup());
        homePage = new HomePage(page);
    }

    @Given("User opens automationpractice.pl web page")
    public void openHomePage() {
        homePage = homePage.open(AUTOMATION_PRACTICE_URL);
    }

    @Given("User clicks on Sign in button")
    public void clickOnSignIn() {
        loginPage = homePage.clickOnSignIn();
    }

    @When("User signs in with valid credentials")
    public void signInWithValidCredentials() {
        loginPage.logIn(USER_EMAIL, Credentials.decrypt(ENCODED_USER_PASSWORD));
    }

    @When("User tries to login with {string} username and {string} password")
    public void signIn(String username, String password) {
        loginPage.logIn(username, password);
    }

    @When("User tries to create an account with {string} email")
    public void createAccount(String email) {
        loginPage.createAccount(email);
    }

    @When("User tries to create an account with exiting email")
    public void createAccountWithExitisingEmail() {
        loginPage.createAccount(USER_EMAIL);
    }

    @Then("Sign out button is visible")
    public void validateIfSignOutIsVisible() {
        assertThat(loginPage.getSignOutButton()).isVisible();
    }

    @Then("User name {string} is displayed properly")
    public void validateIfUserNameIsCorrect(String expectedUserName) {
        assertThat(loginPage.getUserName()).containsText(expectedUserName);
    }

    @Then("Error message {string} should be visible")
    public void validateIfErrorMessageIsDisplayed(String expectedErrorMessage) {
        assertThat(loginPage.getLoginError(expectedErrorMessage)).isVisible();
    }

    @Then("User signs out")
    public void signOut() {
        loginPage.clickOnSignOutButton();
    }

}
