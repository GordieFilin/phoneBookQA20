package dto;

public class UserDTOWith {


    String email;

    String password;



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    //-------------------------------------------


    public UserDTOWith withEmail(String email){
        this.email = email;
        return this;
    }
    public UserDTOWith withPassword(String password){
        this.password = password;
        return this;
    }
}
