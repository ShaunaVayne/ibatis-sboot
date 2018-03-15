package wk.ibatis.sboot.service;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/9/30 下午6:35
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
public class Test2 {

    @Test
    public void test1() {
        Jedis jedis = new Jedis("172.20.10.2", 6379);
        /*int[] b = {1,2,3};
        String[] a = {"1","2","3"};
        jedis.lpush("nums2",a);*/
        List<String> nums2 = jedis.sort("nums2");
        nums2.forEach(num -> {
            System.out.println(num);
        });

    }

    @Test
    public void test2() {
       /* IntFunction<int[]> arrayMaker = int[]::new;
        int[] array = arrayMaker.apply(10);

        for (int i : array) {
            System.out.println(i);
        }*/


        Consumer<ArrayList> runnable = ArrayList::new;
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");

        runnable.accept(list);

       /* Stream.of(runnable).forEach((e) -> {
            System.out.println(e);
        });*/
    }

    @Test
    public void test3() {
		String code = EnumTest.ENUM_01.getCode();
		System.out.println(code);

		System.out.println(EnumTest.ENUM_03.getDesc());

		System.out.println(EnumTest2.TEST_02.getValue());
	}
}
