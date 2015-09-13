package org.msdg.recoder.dao;

import org.msdg.recoder.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2015/9/12.
 */
@Repository
public interface UserDao {

    User getUser(String userName);

    void addUser(User user);

    void updateLoginTime(int id);
}
