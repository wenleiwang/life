package learn.JDKCode.stream;

/**
 * 这里我们不使用lombok的@Date，好用是好用，前两天看了一篇文章，
 * 1.提到jdk升级不支持lombok的升级，lombok不是jdk自带的可能会不兼容
 * 2.对技术栈提出要求
 * 所以此时先不使用lombok
 * @author WangWenLei
 * @DATE: 2020/11/2
 **/
public class User {
    private long id;
    private String name, password, phone, email;
    private boolean vipFlag;

    public User(long id, String name, String password, String phone, String email, boolean vipFlag){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.vipFlag = vipFlag;
    }

    public String toString(){
        return String.format("User[id=%id, name='%s', password='%s' phone='%s', email='%s', isVip='%s']",
                id, name, password, phone, email, vipFlag);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(boolean vipFlag) {
        this.vipFlag = vipFlag;
    }
}
