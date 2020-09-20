package com.String;

/**
 * 字符串反转
 */
public class StringReverseTest {
    public static void main(String[] args) {
        String str = "abcdef";

        String str2 = new StringBuffer(str).reverse().toString();
        System.out.println(str2);
        System.out.println("-----------------------------");

        char[] chars = str.toCharArray();
        for(int i = 0;i< str.length()>>1;i++){
            int j = str.length()-i - 1;
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        System.out.println(String.valueOf(chars));
        System.out.println("-------------------------------");

        String str3 = "";
        for(int i = str.length()-1;i>=0;i--){
            str3 += str.charAt(i);
        }

        System.out.println(str3);

        
    }
}
