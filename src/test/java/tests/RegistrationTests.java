package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class RegistrationTests extends BaseTests{


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
}
