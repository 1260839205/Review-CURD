package cn.aguo.review.service.impl;

import cn.aguo.review.dao.UserDao;
import cn.aguo.review.dao.impl.UserDaoImpl;
import cn.aguo.review.domain.AdminUser;
import cn.aguo.review.domain.PageBean;
import cn.aguo.review.domain.User;
import cn.aguo.review.service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageBean<User> findUserByPage(String _currentPageNumber, String _rows , Map<String,String[]> parame) {

        //将浏览器请求的数据转换为目标格式
        int currentPageNumber = Integer.parseInt(_currentPageNumber);
        int rows = Integer.parseInt(_rows);

        if (currentPageNumber <= 0){
            currentPageNumber = 1;
            rows = 5;
        }

        //查询所有数据的总条数
        int count = ud.findPageUsers(currentPageNumber,rows,parame).size();

        //需要查询到的数据
        List<User> ulist = ud.findPageUsers(currentPageNumber,rows,parame);

        //查询总页码数量
        int totalPageNumber = count % rows == 0 ? count / rows : (count / rows) + 1;

        //数据存入PageBean<User>建立存储对象
        PageBean<User> pbu= new PageBean<User>(count,totalPageNumber,rows,currentPageNumber,ulist);
        return pbu;
    }
}
