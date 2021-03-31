package cn.aguo.review.dao;

import cn.aguo.review.domain.AdminUser;
import cn.aguo.review.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/27 下午4:08
 */
public interface UserDao {

    /**
     * 查询所有的数据的方法
     * @return
     */
    public List<User> findAll();

    /**
     * 添加一个用户
     * @param user
     */
    public void addUser(User user);

    public void deleteUser(int id);

    public User findId(int id);

    public AdminUser loginAdmin(AdminUser au);

    public List<User> findPageUsers(int currentPageNumber, int rows, Map<String,String[]> parame);
}
