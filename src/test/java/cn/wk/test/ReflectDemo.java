package cn.wk.test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/10/17 下午4:17
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
public class ReflectDemo {

	@Test
	public void test1() throws Exception {
		Class<Student> studentClass = Student.class;
		Constructor<?>[] constructors = studentClass.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		System.out.println("-----------1");
		Constructor<?>[] constructors1 = studentClass.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors1) {
			System.out.println(constructor);
		}
		System.out.println("-----------2");
		Constructor<Student> constructor = studentClass.getConstructor(String.class, int.class, String.class);
		System.out.println(constructor);
		System.out.println("-----------3");
		Constructor<Student> constructor1 = studentClass.getDeclaredConstructor(String.class, int.class);
		System.out.println(constructor1);
		Student student = constructor1.newInstance("eason",23);
		System.out.println(student);
		System.out.println("-----------4");
		Student student1 = studentClass.getConstructor().newInstance();
		System.out.println(student1);
	}

	@Test
	public void test2() throws Exception {
		Class<?> classStu = Class.forName("cn.wk.test.Student");
		Field[] fields = classStu.getFields();
		/*Stream.of(fields).forEach(e -> {
			System.out.println(e);
		});*/
		System.out.println(fields.length);
		System.out.println("-----------1");
		Field[] fields1 = classStu.getDeclaredFields();
		Stream.of(fields1).forEach(e ->{
			System.out.println(e);
		});
		System.out.println("-----------2");
		Field addr = classStu.getDeclaredField("addr");
		System.out.println(addr);

		Student student = new Student("eason", 23, "hk");

		addr.setAccessible(true);
		addr.set(student,"hongkang");
		Object o = addr.get(student);
		System.out.println(o.toString());
	}

	@Test
	public void test3() throws Exception{
		Class<Student> studentClass = Student.class;
		Method[] methods = studentClass.getMethods();
		System.out.println(methods.length);
		Method[] methods1 = studentClass.getDeclaredMethods();
		for (Method method : methods1) {
			System.out.println(method);
		}
		Method show = studentClass.getMethod("show", String.class);
		System.out.println(show);
		Student student = studentClass.getConstructor(String.class, int.class, String.class).newInstance("eason", 24, "hk");
		show.invoke(student,"hahaa");
	}

	@Test
	public void test4() throws Exception {
		Student s = new Student("wanghang",20,"humanhhl");
		Class<? extends Student> aClass = s.getClass();
		Field[] fields = aClass.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if(field.getType() == String.class) {
				String str = (String) field.get(s);
				str  = str.replace('h','f');
				field.set(s,str);
			}
		}
		System.out.println(s);
	}

	@Test
	public void test5() throws Exception{
		Student student = new Student();
		Map<Object, Object> map = new HashMap<>();
		map.put("name","eason");
		map.put("age",25);
		map.put("addr","hk");
		loadDemo(map,student);
	}

	private void loadDemo(Map<Object, Object> map, Object obj) throws Exception {
		/*Class<?> aClass = obj.getClass();
		Constructor<?> constructor = aClass.getConstructor(String.class, int.class, String.class);
		Student student = (Student) constructor.newInstance(map.get("name"), map.get("age"), map.get("addr"));
		System.out.println(student.toString());*/
		Class<?> objClass = obj.getClass();
		Field[] fields = objClass.getDeclaredFields();
		Stream.of(fields).forEach(e -> {
			e.setAccessible(true);
			if(e.getName().equals("name")) {
				try {
					e.set(obj,map.get("name"));
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
			}
			if(e.getName().equals("age")) {
				try {
					e.set(obj,map.get("age"));
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
			}
			if(e.getName().equals("addr")) {
				try {
					e.set(obj,map.get("addr"));
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
			}
		});

		System.out.println(obj.toString());
	}

	@Test
	public void test6() throws Exception {
		/**
		 * 加了泛型的集合中, 泛型是对数据类型做了限制, 泛型是一个编译期技术, 在编译成字节码文件后泛型会擦除;
		 * 得到字节码文件后, Arraylist是不带泛型的, 集合的add方法肯定是接收一个Object类型, 反射获取add方法后可以往其中添加任意数据.
		 */
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		Class<? extends ArrayList> aClass = list.getClass();
		Method add = aClass.getDeclaredMethod("add", Object.class);
		add.invoke(list,"haha");
		add.invoke(list,"hehe");
		add.invoke(list,true);
		System.out.println(list);
	}


}
