package cn.aguo.review.domain;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/28 下午8:26
 */
public class AdminUser {
    private int id;
    private String username;
    private String password;
    private String checknumber;

    public AdminUser(int id, String username, String password, String checknumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.checknumber = checknumber;
    }

    public AdminUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
