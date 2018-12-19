package work.dao;

import work.pojo.User;

public interface IUserDao {
    public int insert(User user);   //添加
    public User getOne(String username);  //查找一个

}
