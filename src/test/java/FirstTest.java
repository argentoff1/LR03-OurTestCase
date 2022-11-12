import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;


import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    private static String baseUrl = "https://idemo.bspb.ru/";

    private SelenideElement loginInput = $(By.xpath("//input[@name='username']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@id='login-button']"));

    private SelenideElement codeInput = $(By.xpath("//input[@id='otp-code']"));

    private SelenideElement codeBtn = $(By.xpath("//button[@id='login-otp-button']"));

    private SelenideElement titleText = $(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), 'environment print-hidden')]"));

    private ElementsCollection navMenuButtons = $$(By.xpath("//ul[@class='navigation-menu nav']/li/a"));

    private String[] originalNavMenuButtons = {"ОБЗОР", "СЧЕТА", "ПЛАТЕЖИ И ПЕРЕВОДЫ", "КАРТЫ", "ВКЛАДЫ", "КРЕДИТЫ", "ВАЛЮТА", "СТРАХОВАНИЕ"};

    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000; // Умное ожидание появление элемента на странице
        Configuration.browserSize = "1920x1080"; // Умно
    }


    @BeforeEach
    public void before() {
        open(baseUrl);
    }

    @Step
    public void authStep() {
        loginInput.should(Condition.visible).val("demo");
        passwordInput.should(Condition.visible).val("demo");
        loginBtn.should(Condition.visible).click();
        codeInput.should(Condition.visible).val("0000");
        codeBtn.should(Condition.visible).click();
    }

    @Step
    public void checkNavMenuStep() {
        for (SelenideElement menuItem :
                navMenuButtons) {
            String text = menuItem.should(Condition.visible).getText();
            assertTrue(Arrays.asList(originalNavMenuButtons).contains(text));
        }
    }

    @Test
    public void test() {
        authStep();

        checkNavMenuStep();
    }

    @AfterEach
    public void after() {

    }

}
