package com.fsrm.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @desc 二分查询
 */
public class BinarySearchNon {

    public static void main(String[] args) {
        double index = binarySearch(0, 20, 13.9871);
        System.out.println("匹配值为：" + index);
    }

    /**
     * 非递归
     * @param min 最小值
     * @param max 最大值
     * @param target 需要查找的值
     * @return
     */
    private static double binarySearch(double min,double max, double target) {
        BigDecimal bmin = new BigDecimal(Double.toString(min));
        BigDecimal bmax = new BigDecimal(Double.toString(max));
        BigDecimal btarget = new BigDecimal(Double.toString(target));

        BigDecimal btwo = new BigDecimal("2");
        //误差值
        BigDecimal berr = new BigDecimal("0.00001");
        while (bmin.compareTo(bmax) < 1) {
            BigDecimal badd = bmin.add(bmax);
            //除2求中间值保留5位小数
            BigDecimal bmid = badd.divide(btwo, 5, RoundingMode.HALF_UP);

            System.out.println("要查找的值"+btarget+"====最小值:"+bmin+"====最大值:"+bmax+"====中间值:" + bmid);

            BigDecimal bjian = bmid.subtract(btarget);

            //误差大于0小于误差值
            if (bjian.compareTo(berr) < 1 && bjian.compareTo(BigDecimal.ZERO) == 1) {
                //保留4位小数，直接删除第5位
                BigDecimal bmidScale = bmid.setScale(4,BigDecimal.ROUND_DOWN);
                return bmidScale.doubleValue();
            } else if (bmid.compareTo(btarget) == 1) {
                bmax = bmid;
            } else {
                bmin = bmid;
            }
        }
        return -1;
    }

    /**
     * 递归
     * @param min 最小值
     * @param max 最大值
     * @param target 需要查找的值
     * @return
     */
    private static double binarySearch2(double min,double max, double target) {
        BigDecimal bmin = new BigDecimal(Double.toString(min));
        BigDecimal bmax = new BigDecimal(Double.toString(max));
        BigDecimal btarget = new BigDecimal(Double.toString(target));

        BigDecimal btwo = new BigDecimal("2");

        BigDecimal badd = bmin.add(bmax);
        //除2求中间值保留5位小数
        BigDecimal bmid = badd.divide(btwo, 5, RoundingMode.HALF_UP);
        //误差值
        BigDecimal berr = new BigDecimal("0.00001");
        System.out.println("要查找的值"+btarget+"====最小值:"+bmin+"====最大值:"+bmax+"====中间值:" + bmid);

        BigDecimal bjian = bmid.subtract(btarget);
        //误差大于0小于误差值
        if (bjian.compareTo(berr) < 1 && bjian.compareTo(BigDecimal.ZERO) == 1) {
            //保留4位小数，直接删除第5位
            BigDecimal bmidScale = bmid.setScale(4,BigDecimal.ROUND_DOWN);
            return bmidScale.doubleValue();
        } else if (bmid.compareTo(btarget) == 1) {
            return binarySearch2(bmin.doubleValue(),bmid.doubleValue(),btarget.doubleValue()); // 向左找
        } else {
            return binarySearch2(bmid.doubleValue(),bmax.doubleValue(),btarget.doubleValue()); // 向右找
        }
    }
}
