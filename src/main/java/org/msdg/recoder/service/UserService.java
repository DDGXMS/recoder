package org.msdg.recoder.service;

import org.msdg.framework.exception.ExceptionHandle;
import org.msdg.framework.util.MD5Util;
import org.msdg.framework.word.UserWord;
import org.msdg.recoder.dao.UserDao;
import org.msdg.recoder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/9/12.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(String userName) {
        return userDao.getUser(userName);
    }

    public User getUser(int userId) {
        return userDao.getUserById(userId);
    }

    public User login(String userName, String password) {
        String encryptPwd = MD5Util.MD5(password);

        User user = this.getUser(userName);
        if (null == user) {
            throw ExceptionHandle.USER_NOT_FOUND;
        }

        if (encryptPwd.equals(user.getPassword())) {
            userDao.updateLoginTime(user.getId());
            return user;
        } else {
            throw ExceptionHandle.USER_ERROR(UserWord.PASSWORD_ERROR);
        }
    }
}
