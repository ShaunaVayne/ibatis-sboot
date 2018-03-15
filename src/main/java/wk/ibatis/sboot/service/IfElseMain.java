package wk.ibatis.sboot.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/10/17 下午2:36
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
public class IfElseMain {

	private static Map<String, String> map = new HashMap<String, String>();

	private String name;
	private String age;

	public static void main(String[] args) throws Exception {
		String a = "1";
		test(a);

		map.put("1","-------1-------");
		map.put("2","-------2-------");
		map.put("3","-------3-------");
		IfElseMain ifelse = (IfElseMain) Class.forName("wk.ibatis.sboot.service.IfElseMain").newInstance();

		Method[] methods = ifelse.getClass().getMethods();
		Field[] fields = ifelse.getClass().getFields();
		System.out.println(map.get(a));
		Stream.of(methods).forEach(e -> {
			System.out.println(e);
		});
		Stream.of(fields).forEach(e -> {
			System.out.println(e);
		});
	}

	private static void test(String a) {
		if(a.equals("1")) {
			System.out.println("-------1-------");
		}else if(a.equals("2")) {
			System.out.println("-------2-------");
		}else if(a.equals("3")) {
			System.out.println("-------3-------");
		}
	}


}
