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

public class SecondTest {
    private static String baseUrl = "https://idemo.bspb.ru/";

    private SelenideElement loginInput = $(By.xpath("//input[@name='username']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@id='login-button']"));

    private SelenideElement codeInput = $(By.xpath("//input[@id='otp-code']"));

    private SelenideElement codeBtn = $(By.xpath("//button[@id='login-otp-button']"));

    private SelenideElement cardsBtn = $(By.xpath("//*[@id='cards-overview-index']"));

    private SelenideElement replenishBtn = $(By.xpath("//*[@id='card-details-ownbank-10066']/div[2]/div[2]/div[2]/div/div[1]"));
    private SelenideElement onCardComboBox = $(By.xpath("//*[@id='cards-list-destination-container']/div/select"));
    private SelenideElement onCardExample = $(By.xpath("//*[@id='cards-list-destination-container']/div/select/option[2]"));
    private SelenideElement sumInput = $(By.xpath("//*[@id='amount-form-item']/div/div/input"));
    private SelenideElement nextBtn = $(By.xpath("//*[@id='forward']"));
    private SelenideElement acquaintedCheckBox = $(By.xpath("//*[@id='card-to-card-payment-form']/div[3]/div/div/div/label/input"));
    private SelenideElement clearInputSms = $(By.xpath("//input[@id='otp-input']"));
    //private SelenideElement clearInputSms = $(By.xpath("//*[@id='sms-input']"));
    private SelenideElement confirmBtn = $(By.xpath("/html/body/form/div[2]/button"));

    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000; // Умное ожидание появление элемента на странице
        Configuration.browserSize = "1920x1080"; // Умно
    }


    @BeforeEach
    public void before() {
        open(baseUrl);
    }



    /*@Step
    public void checkNavMenuStep() {
        for (SelenideElement menuItem :
                navMenuButtons) {
            String text = menuItem.should(Condition.visible).getText();
            assertTrue(Arrays.asList(originalNavMenuButtons).contains(text));
        }
    } */

    @Test
    public void test() {
        authStep();

        //checkNavMenuStep();
    }

    @Step
    private void authStep() {
        loginInput.should(Condition.visible).val("demo");
        passwordInput.should(Condition.visible).val("demo");
        loginBtn.should(Condition.visible).click();

        codeInput.should(Condition.visible).val("0000");
        codeBtn.should(Condition.visible).click();

        cardsBtn.should(Condition.visible).click();
        replenishBtn.should(Condition.visible).click();
        onCardComboBox.should(Condition.visible).click();
        onCardExample.should(Condition.visible).click();
        sumInput.should(Condition.visible).val("10000");
        nextBtn.should(Condition.visible).click();
        System.out.println();
//        acquaintedCheckBox.should((Condition.visible)).click();
        //clearInputSms.should(Condition.visible).click();
        //clearInputSms.should(Condition.visible).clear();
//        confirmBtn.should(Condition.visible).click();
        confirmBtn.shouldHave(Condition.visible);
        sleep(1000);
    }

    @AfterEach
    public void after() {

    }
}
