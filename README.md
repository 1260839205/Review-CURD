# 员工管理系统

* 简介 ：员工管理系统利用web网页形式管理员工的信息，管理员可登录系统对员工的信息进行全部查询或者关键字查询、更改员工的基础信息（如职位、QQ、邮箱等）、删除员工以及添加员工

> 一、准备工作
>
> > * 数据库准备
> >
> > * 编译工具
> > * 网络服务器
>
> 二、需求分析
>
> > 1. 管理员登陆
> > 2. 员工管理
>
> 三、 开发
>
> > 1. 数据库设计
> >    * 数据库E-R图设计
> >    * 数据表设计
> > 2. 导入依赖



## 一、准备工作

* 数据库准备 ==> 数据库使用MySQL 8.0
* 编译工具 ==> IntelliJ IDEA 1.4
* 网络服务器 ==> apache-tomcat-8.5.63



## 二、需求分析

1. 管理员登陆：登陆模块（账号由开发者提供单一账号）
2. 员工管理：
   1. 查询方式：
      * 全部查询：直接展示全部员工信息
      * 关键字查询：按照输入关键字查询对应员工（此处使用模糊查询）
   2. 员工信息修改：
      * 统一修改：更改该员工的基础信息
   3. 删除员工：对员工整条信息的删除
   4. 增加员工：添加一条完整的员工信息（姓名、年龄、身份证号、性别、职位、籍贯、QQ、邮箱、联系方式）



## 三、开发

1. 数据库设计

   * 数据库E-R图设计

   * 数据表设计

     --实例管理员表

     | Id   | Username   | Password |
     | ---- | ---------- | -------- |
     | 1    | 1260839205 | 123456   |

     * 字段释意：

       1. Id ==> 编号
       2. username ==> 用户名
       3. password ==> 密码

     * 建表以及录入管理员数据语句

       ```mysql
       create database user; #创建用户数据库
       
       use user; #使用用户数据库
       
       create table adminuser(	#创建管理员表
       	id int primary key auto_increment,	#id字段表示编号
       	username varchar(32) not null, #username字段表示用户名
       	password varchar(32) not null #password字段表示密码
       );
       
       insert into adminuser
       	(username,password)
       	values("1260839205","123456"); #录入一条数据
       ```

     

     --示例员工表

     |Id| Name | Age | Gender | IdentityNumber | Position | Hometown | QQ        | Email        | PhoneNumber |
     | :--: | ---- | ---- | ------------------ | ---- | ---- | --------- | ---------------- | ----------- | ---- |
     |1| 张三 | 18   | 男   | 411111111111111111 | 主管 | 湖北 | 123456789 | 123456789@qq.com | 13333333333 |

     * 字段释意：

       1. Id ==> 编号
       2. Name ==> 姓名
       3. Age ==> 年龄
       4. Gender ==> 性别
       5. IdentityNumber ==> 身份证号
       6. Position ==> 职位
       7. Hometown ==> 籍贯
       8. QQ ==> QQ账号
       9. Email ==> 邮箱
       10. PhoneNumber ==> 手机号

     * 建表以及录入员工数据语句

       ```mysql
       create table staff( #创建员工表
       	id int primary key auto_increment, #id字段表示编号
       	name varchar(32) not null, #name字段表示姓名
       	age int not null,	#age字段表示年龄 
       	gender varchar(10) not null, #gender字段表示性别
       	identitynumber varchar(32) not null unique, #identitynumber字段表示身份证号
       	position varchar(32) not null, #position字段表示职位
       	hometown varchar(32) not null, #hometown字段表示籍贯
       	qq varchar(32) unique, #qq字段表示qq账号
       	email varchar(32) unique, #Email字段表示邮箱
       	phonenumber varchar(32) not null unique #phonenumber字段表示手机号
       );
       
       insert into staff #录入一条员工信息
       	(name,age,gender,identitynumber,position,hometown,qq,email,phonenumber)
       	values
       	("张三",18,"男","411111111111111111","主管","湖北","123456789","123456789@qq.com","13409688162");
       ```

       







