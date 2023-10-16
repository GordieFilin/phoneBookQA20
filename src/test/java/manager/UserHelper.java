package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnOpenLoginForm = By.xpath("//a[@href='/login']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btnLogin = By.xpath("//button[@name='login']");

    By btnReg = By.xpath("//button[@name='registration']");
    String btnRegistration = "document.querySelector('[name=\"registration\"]').click();\n";
    By textContacts = By.xpath("//a[@href='/contacts']");

    By loginFailed = By.xpath("//div[@id='root']/..//div//div//div//div");

    By btnSignOut = By.xpath("//button");

    public void fillLoginUserDto(UserDTO userDTO) {
        clickBase(btnOpenLoginForm);
        typeTextBase(inputEmail, userDTO.getEmail());
        typeTextBase(inputPassword, userDTO.getPassword());
        clickBase(btnLogin);
    }

    public void fillLoginUserDtoWith(UserDTOWith userDTOWith) {
        clickBase(btnOpenLoginForm);
        typeTextBase(inputEmail, userDTOWith.getEmail());
        typeTextBase(inputPassword, userDTOWith.getPassword());
        clickBase(btnLogin);
    }

    public void loginUserDtoLombok(UserDtoLombok user){
        clickBase(btnOpenLoginForm);
        typeTextBase(inputEmail, user.getEmail());
        typeTextBase(inputPassword, user.getPassword());
        clickBase(btnLogin);
    }

    public boolean validateContactTextDisplaysMainMenu() {
        String expectedResult = "CONTACTS".toUpperCase();
        return isTextEqual(textContacts, expectedResult);
    }

    public void fillRegistrationForm(UserDtoLombok user) {
        clickByXY(btnOpenLoginForm, 2 ,5);
        typeTextBase(inputEmail, user.getEmail());
        typeTextBase(inputPassword, user.getPassword());
        jsClickBase(btnRegistration);
      //  clickBase(btnReg);

    }

    public boolean validateLoginIncorrect() {
       // pushEnter();
        return isTextEqual(btnOpenLoginForm, "LOGIN");
    }

    public boolean validateRegIncorrect () {
        // pushEnter();
        return isTextEqual(btnOpenLoginForm, "LOGIN");
    }

    public boolean btnSignOutExist() {
        return isElementExist(btnSignOut);
    }

    public void signOut() {
        clickBase(btnSignOut);
    }
}
