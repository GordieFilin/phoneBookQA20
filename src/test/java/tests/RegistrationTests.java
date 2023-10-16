package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class RegistrationTests extends BaseTests{

    @BeforeTest

    public void preconditionsLogin() {
        app.navigateToMainPage();
        logoutIfLogin();
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
    public void negativeRegistration(){
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("aaaaaaAa!")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateRegIncorrect());

    }
}
