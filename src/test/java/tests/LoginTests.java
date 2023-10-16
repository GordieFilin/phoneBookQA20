package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    UserDTOWith userDTOWith = new UserDTOWith()
            .withEmail("testqa20@gmail.com")
            .withPassword("123456Aa$");
    UserDTO userDTO = new UserDTO("testqa20@gmail.com", "123456Aa$");

    @BeforeTest

    public void preconditionsLogin() {
        app.navigateToMainPage();
        logoutIfLogin();
    }
    @Test
    public void positiveLoginUserDto() {
        app.getUserHelper().fillLoginUserDto(userDTO);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }

    @Test
    public void positiveLoginUserDtoWith() {
        app.getUserHelper().fillLoginUserDtoWith(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }

    @Test
    public void positiveLogin(){
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aa$")
                .build();

        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }

    @Test
    public void negativeLoginWithoutNumbers(){
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("aaaaaaAa$")
                .build();

        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validateLoginIncorrect());
    }

}
