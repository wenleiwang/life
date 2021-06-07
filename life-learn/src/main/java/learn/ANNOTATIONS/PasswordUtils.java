package learn.ANNOTATIONS;

import java.util.List;

/**
 * 使用注解的地方
 * @author WangWenLei
 * @DATE: 2020/11/26
 **/
public class PasswordUtils {
    @UseCase(id = 47,description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String passwd){
        return (passwd.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String passwd){
        return new StringBuilder(passwd).reverse().toString();
    }

    @UseCase(id = 49 ,description = "New Passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords , String passwd){
        return !prevPasswords.contains(passwd);
    }


}
