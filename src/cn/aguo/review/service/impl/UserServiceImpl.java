package cn.aguo.review.service.impl;

import cn.aguo.review.dao.UserDao;
import cn.aguo.review.dao.impl.UserDaoImpl;
import cn.aguo.review.domain.AdminUser;
import cn.aguo.review.domain.User;
import cn.aguo.review.service.UserService;

import java.util.List;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/27 下午4:37
 */
public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        System.out.println("UserService执行了");
        return ud.findAll();
    }

    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        ud.deleteUser(Integer.parseInt(id));
    }

    @Override
    public void delSelecedUser(String[] id) {
        for (int i = 0; i < id.length; i++) {
            System.out.println(id[i]);
            if (i != 0) {
                ud.deleteUser(Integer.parseInt(id[i]) - 1);
            }else {
                ud.deleteUser(Integer.parseInt(id[i]));
            }
        }
    }

    @Override
    public User findId(String id) {
        return ud.findId(Integer.parseInt(id));
    }

    @Override
    public boolean loginAdmin(AdminUser au) {
        boolean flog;
        if (ud.loginAdmin(au) != null){
            flog = true;
        }else {
            flog = false;
        }
        return flog;
    }
}
