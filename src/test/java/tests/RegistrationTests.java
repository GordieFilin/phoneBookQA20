package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class RegistrationTests extends BaseTests{

    @BeforeMethod

    public void preconditionsLogin() {
        app.navigateToMainPage();
        logoutIfLogin();
    }

    @AfterMethod
    public void postConditionsAlert(){
        app.getUserHelper().clickAlert();
    }


    @Test
    public void positiveRegistration(){
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("123456Aa!")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());

    }

    @Test
    public void negativeRegistrationNoDigits(){
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("aaabaaAa!")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrectReg());

    }

    @Test
    public void negativeRegistrationNoLetters(){
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("12345678!")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrectReg());

    }
    @Test
    public void negativeRegistrationNoSymbol(){
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("1234aA789")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailPasswordCorrectReg());

    }
}
