package org.cc.leetcode.onehundred.twenty;

import org.apache.commons.lang.StringUtils;

/**
 * https://leetcode.cn/problems/roman-to-integer/description/?languageTags=java
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num13 {
    public static void main(String[] args) {
        Num13 test=new Num13();
//        ListNode.printListNode();
//        int[] tar={-1,0,1,2,-1,-4};
//        int[] tar={3,-2,1,0};

        int[] tar={ 3,0,-2,-1,1,2};

        int res=test.romanToInt("LVIII");
        System.out.println("res   "+res);
    }


//    String[] romachars=new String[]{
//            "M",      "CM","D","CD","C",       "XC","L","XL","X",             "IX","V","IV","I"
//    };
//    int[] nums=new int[]{1000,   900,500,400,100,      90,50,40,10,            9,5,4,1};
    private  int getVal(char c){
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C' :return      100;
            case 'D' :return   500;
            case 'M'  :return  1000;
            default:return 0;
        }
    }
    public int romanToInt(String s) {
        int pre=getVal(s.charAt(0));
        int sum=0        ;
        if(StringUtils.isNotBlank(s)){
            for (int i = 1; i <s.length() ; i++) {
                int num=getVal(s.charAt(i));
                if(pre<num){
                    sum-=pre;
                }else {
                    sum+=pre;
                }
                pre=num;
            }
            sum+=pre;//处理最后一位
        }else {
            return -1;
        }
        return sum;
    }
}



/****
 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给定一个罗马数字，将其转换成整数。



 示例 1:

 输入: s = "III"
 输出: 3
 示例 2:

 输入: s = "IV"
 输出: 4
 示例 3:

 输入: s = "IX"
 输出: 9
 示例 4:

 输入: s = "LVIII"
 输出: 58
 解释: L = 50, V= 5, III = 3.
 示例 5:

 输入: s = "MCMXCIV"
 输出: 1994
 解释: M = 1000, CM = 900, XC = 90, IV = 4.


 提示：

 1 <= s.length <= 15
 s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 *
 *
 *
 *
 * 羅馬數字共有7個，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。按照下述的規則可以表示任意正整數。需要注意的是罗马数字中没有“0”，與進位制無關。一般認為羅馬數字只用來記數，而不作演算。
 *
 * 重複數次：一個羅馬數字重複幾次，就表示這個數的幾倍。
 * 右加左減：
 * 在較大的羅馬數字的右邊記上較小的羅馬數字，表示大數字加小數字。
 * 在較大的羅馬數字的左邊記上較小的羅馬數字，表示大數字减小數字。
 * 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
 * 但是，左減時不可跨越一個位值。比如，99不可以用IC（100-1）表示，而是用XCIX（[100-10]+[10-1]）表示。（等同於阿拉伯數字每位數字分別表示。）
 * 左減數字必須為一位，比如8寫成VIII，而非IIX。
 * 右加數字不可連續超過三位，比如14寫成XIV，而非XIIII。（見下方“數碼限制”一項。）
 * 加線乘千：
 * 在羅馬數字的上方加上一條橫線或者加上下標的M，表示將這個數乘以1000，即是原數的1000倍。
 * 同理，如果上方有兩條橫線，即是原數的1000000（1000^{{2}}）倍。
 * 數碼限制：
 * 同一數碼最多只能连续出現三次，如40不可表示為XXXX，而要表示為XL。
 * 例外：由於IV是古羅馬神話主神朱庇特（即IVPITER，古羅馬字母裡沒有J和U）的首字，因此有時用IIII代替IV。
 * */