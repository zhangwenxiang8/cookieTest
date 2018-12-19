package work.service;

import work.dao.IUserDao;
import work.dao.UserDaoImpl;
import work.pojo.User;

public class UserServicelmpl implements IUserService {

    private IUserDao dao=new UserDaoImpl();

    @Override
    public int insert(User user) {
        return dao.insert(user);      //调取dao层方法过来
    }

    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }
}
