package com.fsrm.excel;

import java.util.Calendar;

public class StrTest {
    public static void main(String[] args) {
        int age = 0;

        String idCard = "511702800222130";
        if (idCard.length() == 15){
            idCard = idCard.substring(0, 6) + "19" + idCard.substring(6);//加入年份，变成17位

            //计算校验位   begin
            char[] Ai = idCard.toCharArray();
            int[] Wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            char[] verifyCode = {'1','0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
            int S = 0;
            int Y;
            for(int i = 0; i < Wi.length; i++){
                S += (Ai[i] - '0') * Wi[i];
            }
            Y = S % 11;
            //校验位计算结果verifyCode[Y] end

            idCard += verifyCode[Y];
        }
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        System.out.println("现在年份==" + yearNow);
        int monthNow = cal.get(Calendar.MONTH)+1;
        System.out.println("现在月份==" + monthNow);
        int dayNow = cal.get(Calendar.DATE);
        System.out.println("现在天==" + dayNow);

        int year = Integer.valueOf(idCard.substring(6, 10));
        System.out.println("身份证年==" + year);
        int month = Integer.valueOf(idCard.substring(10,12));
        System.out.println("身份证月==" + month);
        int day = Integer.valueOf(idCard.substring(12,14));
        System.out.println("身份证日==" + day);

        if ((month < monthNow) || (month == monthNow && day<= dayNow) ){
            age = yearNow - year;
        }else {
            age = yearNow - year-1;
        }
        System.out.println("年龄==" + age);
    }
}
