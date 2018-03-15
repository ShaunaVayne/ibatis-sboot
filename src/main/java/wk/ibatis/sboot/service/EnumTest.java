package wk.ibatis.sboot.service;

import lombok.Getter;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/10/17 下午3:04
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
@Getter
public enum EnumTest {

	ENUM_01("1","测试1"),
	ENUM_02("2","测试2"),
	ENUM_03("3","测试3"),
	ENUM_04("4","测试4");

	private String code;

	private String desc;

	EnumTest(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
