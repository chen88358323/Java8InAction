package lambdasinaction.cc.lambda.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName : ConvertTest
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2022-09-21 10:18
 */
public class ConvertTest {
    public static void main(String[] args) {
        filterTest();
        groupTest();
    }

    private static void groupTest(){
        Map<String ,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        List<User> userList=new ArrayList<>();
        User u=null;
        for (int i = 0; i <100 ; i++) {
            map.put("nname"+i,i/3);
            list.add(i/3);
            u=new User(i,"name"+i);
            userList.add(u);
        }
//        Map<String,Integer> gIntMap=userList.stream().
//                collect(Collectors.groupingBy(u.getName(),Collectors.counting(u.getAge())));
//        gIntMap.forEach((k,v)->{
//                System.out.println(k + " = " + v);
//        });
//        System.out.println(gIntMap);

//       Map<Integer,Map<String,Integer>> list2=map.entrySet().stream().collect(Collectors.groupingBy(
//                  gmap->(gmap.getValue() )
//       );
    }
    private static void filterTest(){
        Map<Integer ,String> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        List<User> userList=new ArrayList<>();
        User u=null;
        for (int i = 0; i <10 ; i++) {
            map.put(i,"nname"+i);
            list.add(i);
            u=new User(i,"name"+i,i/3);
            userList.add(u);
        }
//        Map< String,Integer>  umap=
                userList.stream().collect(Collectors.groupingBy(User::getName,Collectors.groupingBy(User::getAge)));


        Stream<Map.Entry<Integer,String>> stream=map.entrySet().stream();

        stream.filter(m->(m.getKey()>3));


        List<Integer> ll=list.stream().filter(i->(i>3)).collect(Collectors.toList());
        for (Integer i:ll
             ) {
            System.out.print(i+" ");
        }
        System.out.println();
//        stream.filter(map<Integer,String>->(id>3));


        userList.stream().filter(user -> (user.getId()>3));
    }



    private static void reduceTest(){
        Map<Integer ,String> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        List<User> userList=new ArrayList<>();
        User u=null;
        for (int i = 0; i <10 ; i++) {
            map.put(i,"nname"+i);
            list.add(i);
            u=new User(i,"name"+i,i/3);
            userList.add(u);
        }

        int res=list.stream().reduce(0,(sum ,age)->sum+age);
        System.out.println("reduce test List<Integer>==>"+res);
//        Map< String,Integer>  umap=

        Integer num=userList.stream().map(k->(k.getAge())).reduce(new Integer(0),(sum ,age)->{
            sum+=age;
            return sum;
        });
        System.out.println("all user age sum=>"+num);

        Stream<Map.Entry<Integer,String>> stream=map.entrySet().stream();

        stream.filter(m->(m.getKey()>3));


        List<Integer> ll=list.stream().filter(i->(i>3)).collect(Collectors.toList());
        for (Integer i:ll
        ) {
            System.out.print(i+" ");
        }
        System.out.println();
//        stream.filter(map<Integer,String>->(id>3));


        userList.stream().filter(user -> (user.getId()>3));
    }

    private static void mapTest(){
        Map<Integer ,String> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        List<User> userList=new ArrayList<>();
        User u=null;
        for (int i = 0; i <10 ; i++) {
            map.put(i,"nname"+i);
            list.add(i);
            u=new User(i,"name"+i,i/3);
            userList.add(u);
        }
//         List<Integer> list  case
        List<String> strlist=list.stream().map(num->num+"tset").collect(Collectors.toList());
        System.out.println(strlist);

        //map  case
//        map.entrySet().stream().map(entry->entry.getValue(),entry.ge)

       //userlist case
        userList=userList.stream().map(user->{
           if(user.getAge()>15){
               user.setTag(1);
           }else {
               user.setTag(2);
           }
           return  user;
       }).collect(Collectors.toList());


        System.out.println();

//        Stream<Map.Entry<Integer,String>> stream=map.entrySet().stream().map(entry->{
//            Map.Entry<String,Integer> en;
//            entry.getKey()
//                    ent
//
//        });


    }
}
class User {
    private  Integer id;
    private String name;
    private Integer age;
    private String country;
    private  int tag;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public User(){}
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}