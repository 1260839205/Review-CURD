package cn.aguo.review.dao.impl;

import cn.aguo.review.dao.UserDao;
import cn.aguo.review.domain.AdminUser;
import cn.aguo.review.domain.User;
import cn.aguo.review.util.JdbcUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public List<User> findPageUsers(int currentPageNumber, int rows , Map<String ,String[]> parame) {
        //定义sql
        String sql = "select * from info where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<String> list = new ArrayList<>();

        //获取起始索引
        int frist = (currentPageNumber - 1 ) * rows;

        //遍历parame并且排除currentPageNumber和rows
        Set<String> parameset = parame.keySet();
        for (String key : parameset) {
            if ("currentPageNumber".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = parame.get(key)[0];
            //确认传过来的值是否有效,有效则获取
            System.out.println(key);
            if (value != null && !"".equals(value)){
                sb.append("and "+key+" like '%"+value+"%' ");
            }
        }
        sb.append("limit ?,?");
        sql = sb.toString();
        System.out.println(sql);
        List<User> ulsit = template.query(sql, new BeanPropertyRowMapper<>(User.class), frist, rows);

        return ulsit;
    }
}
