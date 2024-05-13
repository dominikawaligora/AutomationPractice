import com.microsoft.playwright.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;

public class FirstTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext browserContext;
    protected static Page page;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterEach
    void closeContextAndPage() {
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }

    @Test
    void loginAndCheckPersonalInformation() {
        String codedPassword = encrypt("aq4jaLKBJ6QW@bT");
        String encodedPassword = decrypt(codedPassword);
        page.navigate("http://www.automationpractice.pl/index.php");
        page.locator("a[class=\"login\"]").click();
        page.locator("input[id=\"email\"]").fill("wieczorek.dominika@gmail.com");
        page.locator("input[id=\"passwd\"]").fill(encodedPassword);
        page.locator("button[id=\"SubmitLogin\"]").click();

        //assert
        page.locator("a[title=\"View my customer account\"]").click();
        page.getByText("My personal information").click();
        page.getByText("bleble").click();
    }

    //base64 encoding: This is used to encrypt the password and save the encrypted value in config.properties file
    public static String encrypt(String password) {
        String encodedPassword = "";
        try {
            byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes("UTF-8"));
            encodedPassword = new String(encodedBytes);
        } catch (Exception e) {
            System.out.println("Password was not Encrypted.");
        }
        return encodedPassword;
    }

    //YXE0amFMS0JKNlFXQGJU
    public static String decrypt(String encodedPassword) {
       // String encodedBytes = WebActions.getProperty(passwordField);
        String decodedPassword = "";
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            decodedPassword = new String(decodedBytes);
        } catch (Exception e) {
            System.out.println("Password was nor decrypted.");
        }
        return decodedPassword;
    }
}
