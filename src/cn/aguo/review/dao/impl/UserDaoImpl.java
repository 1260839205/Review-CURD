package cn.aguo.review.dao.impl;

import cn.aguo.review.dao.UserDao;
import cn.aguo.review.domain.AdminUser;
import cn.aguo.review.domain.User;
import cn.aguo.review.util.JdbcUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/27 下午4:17
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //定义sql语句
        String sql = "select * from info";

        //查询
        List<User> listUser = template.query(sql,new BeanPropertyRowMapper<>(User.class));
        System.out.println("UserDaoImpl执行了");
        System.out.println(listUser.get(0).toString());
        return listUser;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into info values (null,?,?,?,?,?,?)";

        template.update(sql,user.getName(),user.getGender(),user.getAge()
                ,user.getHometown(),user.getQq(),user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        //删除信息的SQL语句
        String sql = "delete from info where id = ?";

        //执行删除语句
        template.update(sql,id);

        //删除主键语句 --避免断层问题出现
        sql = "ALTER TABLE info DROP id";

        template.update(sql);

        //重新设定id自动增长语句 --达到id重置的效果
        sql = "ALTER TABLE info ADD COLUMN id INT PRIMARY KEY AUTO_INCREMENT FIRST";

        template.update(sql);
    }

    @Override
    public User findId(int id) {
        String sql = "select * from info where id = ?";

        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
        return user;
    }

    @Override
    public AdminUser loginAdmin(AdminUser au) {
        try {
            String sql = "select * from adminuser where username = ? and password = ?";
            AdminUser adminUser = template.queryForObject(sql, new BeanPropertyRowMapper<AdminUser>(AdminUser.class), au.getUsername(), au.getPassword());
            return adminUser;
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            return null;
        }

    }
}
