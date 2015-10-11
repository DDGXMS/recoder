package org.msdg.recoder.controller.property;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * Created by Administrator on 2015/10/11.
 */
public class LongToDateEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isBlank(text)) {
            setValue(null);
        }
        if (!StringUtils.isNumeric(text)) {
            throw new RuntimeException("期待毫秒数，但是给的是：" + text);
        }
        Date date = new Date();
        date.setTime(Long.parseLong(text));
        setValue(date);
    }
}
