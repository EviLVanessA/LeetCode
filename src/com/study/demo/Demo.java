package com.study.demo;

import java.util.Calendar;
import java.util.Date;

/**
 * @author jianghui
 * @date 2022/5/24
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(getMonth());
    }

    public static int getUserAge(String idcard) {
        try {
            int age = 0;
            String birth = "";
            if (idcard.length() == 18) {
                birth = idcard.substring(6, 14);
            } else if (idcard.length() == 15) {
                birth = "19" + idcard.substring(6, 12);
            }
            int year = Integer.parseInt(birth.substring(0, 4));
            int month = Integer.parseInt(birth.substring(4, 6));
            int day = Integer.parseInt(birth.substring(6));
            Calendar cal = Calendar.getInstance();
            age = cal.get(Calendar.YEAR) - year;
            //周岁计算
            if (cal.get(Calendar.MONTH) < (month - 1) || (cal.get(Calendar.MONTH) == (month - 1) && cal.get(Calendar.DATE) < day)) {
                age--;
            }
            return age;
        } catch (Exception e) {
            e.getMessage();
        }
        return -1;
    }

    public static int getMonth() {
        long time = System.currentTimeMillis() - (long) 1000 * 60 * 60 * 60 * 60 * 10;
        Date date = new Date(time);
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        cal.setTime(new Date());
        int monthCount = (cal.get(Calendar.YEAR) - year) * 12;
        monthCount += cal.get(Calendar.MONTH) - month;
        return monthCount;
    }
}
