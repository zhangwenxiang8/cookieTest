package work.service;

import work.pojo.User;

public interface IUserService {
    public int insert(User user);
    public User getOne(String username);
}
