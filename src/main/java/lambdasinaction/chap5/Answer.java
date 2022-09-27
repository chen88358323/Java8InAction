package lambdasinaction.chap5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName : Answer
 * Q:
 * (1)找出2011年发生的所有交易，并按交易额排序（从低到高）。
 * (2) 交易员都在哪些不同的城市工作过？
 * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
 * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
 * (5) 有没有交易员是在米兰工作的？
 * (6) 打印生活在剑桥的交易员的所有交易额。
 * (7) 所有交易中，最高的交易额是多少？
 * (8) 找到交易额最小的交易。
 * @Description : 第五章开头练习题
 * @param:
 * @Author : CC
 * @Date: 2022-09-22 09:39
 */
public class Answer {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Trader> traderList=new ArrayList<>();
        traderList.add(raoul);
        traderList.add(mario);
        traderList.add(alan);
        traderList.add(brian);



        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        answer1(traderList,transactions);

        answer2(traderList,transactions);

        answer3(traderList,transactions);

        answer4(traderList,transactions);

        answer5(traderList,transactions);
    }
/**
 * @ClassName : Answer
 * (1)找出2011年发生的所有交易，并按交易额排序（从低到高）。
 * (7) 所有交易中，最高的交易额是多少？
 * (8) 找到交易额最小的交易。
 * */
    private static void answer1( List<Trader> t1, List<Transaction> t2){
        System.out.println("start  run method："+getMethodName());
        List<Transaction> list;
        list = t2.stream().filter(transaction -> transaction.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(list);

    }
    private  static String getMethodName(){
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        String methodName = stackTrace[1].getMethodName();
        return methodName;
    }

    /**
     * @ClassName : Answer
     * (6) 打印生活在剑桥的交易员的所有交易额。
     */
    private static void answer6(List<Trader> t1, List<Transaction> t2){
        System.out.println("start  run method："+getMethodName());

//        List<Trader> list =t1.stream().filter(trader -> ("Cambridge".equals(trader.getCity()))).collect(Collectors.toList());
//                .map((trader,)->(trader.getName().equals(tran.get)));
//
//        t1.stream().findAny().ifPresent(trader ->  {
//            if (trader.getCity().equals("Milan")){
//                System.out.println(" Q4  trader:"+trader);
//            }
//        });
//
//        System.out.println("Q4.有没有交易员是在米兰工作的?"+res);

    }
    /**
     * @ClassName : Answer
     * (5) 有没有交易员是在米兰工作的？
     */
    private static void answer5(List<Trader> t1, List<Transaction> t2){
        System.out.println("start  run method："+getMethodName());
        List<Trader> list;
        boolean res=t1.stream().anyMatch(trader -> (trader.getCity().equals("Milan")));
        t1.stream().findAny().ifPresent(trader ->  {
            if (trader.getCity().equals("Milan")){
                System.out.println(" Q4  trader:"+trader);
            }
        });

        System.out.println("Q4.有没有交易员是在米兰工作的?"+res);

    }
    /**
     * @ClassName : Answer
     * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
     */
    private static void answer4(List<Trader> t1, List<Transaction> t2){
        System.out.println("start  run method："+getMethodName());
        List<Trader> list;
        list = t1.stream().
                sorted(Comparator.comparing(Trader::getName)).
                collect(Collectors.toList());
//按字母顺序排序没有做  以下为正确答案
        String traderStr =
                t1.stream()
                        .map(transaction -> transaction.getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);//TODO reduce 怎么用还不熟

        System.out.println(list);

    }
    /**
     * @ClassName : Answer
     * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
     */
    private static void answer3 (List<Trader> t1, List<Transaction> t2){
        System.out.println("start  run method："+getMethodName());
        List<Trader> list;
        list = t1.stream().
                filter(trader -> trader.getCity().equals("Cambridge")).
                sorted(Comparator.comparing(Trader::getName)).
                collect(Collectors.toList());

        System.out.println(list);

    }
/**
 * @ClassName : Answer
 * (2) 交易员都在哪些不同的城市工作过？
 */
    private static void answer2 (List<Trader> t1, List<Transaction> t2){
        System.out.println("start  run method："+getMethodName());
        List<Trader> list;
        Map<String,List<Trader>> map = t1.stream().collect(Collectors.groupingBy( Trader::getCity ));

        System.out.println(map.keySet());

    }
}