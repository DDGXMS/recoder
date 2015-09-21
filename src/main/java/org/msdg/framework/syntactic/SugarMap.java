package org.msdg.framework.syntactic;

import java.util.HashMap;

/** 
 * Map语法糖
 *
 * @author syy
 * @date 2014-11-21 上午12:40:59 
 */
public class SugarMap {

    public static HashMap<String, Object> paramMap(Object...objects) {
        HashMap<String, Object> map = new HashMap<>(objects.length/2);
        for (int i=1; i<objects.length; i=i+2) {
            map.put(objects[i - 1].toString(), objects[i]);
        }
        return map;
    }

    public static HashMap<Object, Object> objectMap(Object...objects) {
        HashMap<Object, Object> map = new HashMap<>(objects.length/2);
        for (int i=1; i<objects.length; i=i+2) {
            map.put(objects[i - 1], objects[i]);
        }
        return map;
    }
    
    public static HashMap<String, String> stringMap(String...strings) {
        HashMap<String, String> map = new HashMap<>(strings.length/2);
        for (int i=1; i<strings.length; i=i+2) {
            map.put(strings[i-1], strings[i]);
        }
        return map;
    }
}
