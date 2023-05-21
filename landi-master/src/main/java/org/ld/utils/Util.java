package org.ld.utils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/**
 * Created by lenovo on 2017/12/5.
 */
public class Util {
    public static String preMonth(String month){
        String temp = "";
        if(month.charAt(0) == '0' && month.charAt(1) == '1'){
            temp = "12";
        }else if(month.charAt(0) == '1' && month.charAt(1) == '0'){
            temp = "09";
        }else {
            temp = String.valueOf(month.charAt(0)) + String.valueOf((char)(month.charAt(1)-1));
        }
        return temp;
    }

    /** 字符串转数组
     * @param str
     * @return List<String></>
     * */
    public static List<String> StringPareList(String str) {
        List<String> List = new ArrayList<>();
        if (StringUtils.isNotEmpty(str)) {
            // 字符串转List
            String[] args = str.split(",");
            for (String temp : args) {
                List.add(temp);
            }

        }
        return List;
    }
    /** 字符串转数组
     * @param str
     * @return List<Integer></>
     * */
    public static List<Integer> StringPareListInteger(String str) {
        List<Integer> List = new ArrayList<>();
        if (StringUtils.isNotEmpty(str)) {
            // 字符串转List
            String[] args = str.split(",");
            for (String temp : args) {
                List.add(Integer.parseInt(temp));
            }

        }
        return List;
    }
    
    
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;
        else if (obj instanceof CharSequence) return ((CharSequence) obj).length() == 0;
        else if (obj instanceof Collection) return ((Collection) obj).isEmpty();
        else if (obj instanceof Map) return ((Map) obj).isEmpty();
        else if (obj.getClass().isArray()) return Array.getLength(obj) == 0;

        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

}
