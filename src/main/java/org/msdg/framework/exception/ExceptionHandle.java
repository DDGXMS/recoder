package org.msdg.framework.exception;

import org.msdg.framework.word.UserWord;
import org.msdg.recoder.exception.UserException;
import org.msdg.recoder.exception.UserNotFoundException;

/**
 * Created by Administrator on 2015/9/12.
 */
public class ExceptionHandle {

    public static UserNotFoundException USER_NOT_FOUND = new UserNotFoundException();

    public static UserException USER_ERROR(UserWord word) {
        return new UserException(word.toString());
    }
}
