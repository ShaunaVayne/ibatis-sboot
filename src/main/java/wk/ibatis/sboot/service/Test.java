package wk.ibatis.sboot.service;

import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/14 下午2:18
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
public class Test {

    @org.junit.Test
    public void test() {
        Consumer<String> stringConsumer = (String s) -> System.out.println(s);
        stringConsumer.accept("3443");

        IntBinaryOperator intBinaryOperator = (int x, int y) -> x + y;
        int i = intBinaryOperator.applyAsInt(3, 4);

        IntBinaryOperator intBinaryOperator1 = (int a, int b) -> a * b;

        IntConsumer intConsumer = (int result) -> System.out.println(result);

        intConsumer.accept(intBinaryOperator1.applyAsInt(4,50));

        Runnable runnable = () -> System.out.println("hello lambda");

        runnable.run();

        ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("d");

    }

    @org.junit.Test
    public void test2() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        java.util.List<String> players = Arrays.asList(atp);

        //使用lambda进行遍历
        //players.forEach(player -> System.out.println(player));
        System.out.println("hha");
        players.forEach(System.out::println);
    }

    @org.junit.Test
    public void test3() {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("a","1");
        map1.put("b","2");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("c","3");
        map2.put("d","4");
        list.add(map1);
        list.add(map2);
        list.stream().flatMap((map) -> map.entrySet().stream()).forEach((e) ->{
            System.out.println(e.getKey() + "-------"+ e.getValue());
        });
    }

    @org.junit.Test
    public void test4() {
        Jedis jedis = new Jedis("192.168.157.67", 6379);
        byte[] bytes = jedis.dump("song2");
        Stream.of(bytes).forEach((e) -> {
           System.out.println(e.toString());
        });
    }

    @org.junit.Test
    public void test5() {
        Jedis jedis = new Jedis("192.168.157.67", 6379);
        java.lang.String s = jedis.get("song2");
        Long game = jedis.objectRefcount("game");
        java.lang.String age2 = jedis.objectEncoding("song2");
        jedis.get("phone");
        Long phone = jedis.objectIdletime("phone");
        System.out.println(s);
        System.out.println(game);
        System.out.println(age2);
        System.out.println(phone);
    }

    @org.junit.Test
    public void test6() {
        Jedis jedis = new Jedis("192.168.157.67", 6379);
        jedis.set("test","hello,dumping world!");
        byte[] tests = jedis.dump("test");
        jedis.restore(tests,2,null);
    }

    @org.junit.Test
    public void test7() {
        Jedis jedis = new Jedis("192.168.157.67", 6379);
        Set<String> keys = jedis.keys("*");
        keys.stream().forEach((e) -> {
            System.out.println(e);
        });
        String greet = jedis.get("greet");
        System.out.println(greet);
        Long a = jedis.setnx("greet3", "test2");
        System.out.println(a);
        System.out.println(jedis.get("greet3"));
    }

    static CarEnum mycar;
    @org.junit.Test
    public void test8() {
        System.out.println(mycar.BMW.getCarType());
        System.out.println(mycar.TOYOTA.getCarType());

    }

}
