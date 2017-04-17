package com.cxria.livetest.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yukun on 17-4-17.
 */
public class PhoneCheckUtils {

    /**
     * 验证手机号码
     *
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
     * 联通号码段:130、131、132、136、185、186、145
     * 电信号码段:133、153、180、189
     *
     * @param cellphone 电话号码
     * @return
     */
    public static boolean checkCellphone(String cellphone) {
//        Pattern p = Pattern.compile("^\\d{11}$");
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(cellphone);
        return m.matches();
    }}
