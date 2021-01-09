package com.study.leetcode101_200.leetcode151_175;

/**
 * @author jianghui
 * @date 2021-01-08 18:13
 */
public class LeetCode165 {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.min(v1.length,v2.length);
        int i ;
        for (i = 0; i < len; i++) {
            if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                return -1;
            }else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                return 1;
            }
        }
        if (v1.length == v2.length){
            return 0;
        }else {
            if (v1.length > v2.length){
                for (int j = i; j < v1.length; j++) {
                    if (Integer.parseInt(v1[j]) > 0){
                        return 1;
                    }
                }
            }else {
                for (int j = i; j < v2.length; j++) {
                    if (Integer.parseInt(v2[j]) > 0){
                        return -1;
                    }
                }
            }
        }
        return 0;
    }
    public static int compareVersion2(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion2("1.0.0", "1"));
    }
}
