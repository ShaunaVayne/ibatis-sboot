package cn.wk.test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/10/17 下午4:16
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
@Setter
@Getter
@ToString
public class Student {

	private String name;

	private int age;

	private String addr;

	public Student(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public Student() {
	}

	public void show(String value) {
		System.out.println("开始你的表演"+ value);
	}
}
