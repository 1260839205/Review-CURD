package cn.aguo.review.service;

import cn.aguo.review.domain.AdminUser;
import cn.aguo.review.domain.User;

import java.util.List;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/27 下午4:36
 */
public interface UserService {
    public List<User> findAll();

    public void  addUser(User user);

    public void deleteUser(String id);

    public void delSelecedUser(String[] id);

    public User findId(String id);

    public boolean loginAdmin(AdminUser au);
}
