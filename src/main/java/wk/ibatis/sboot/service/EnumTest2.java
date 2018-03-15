package wk.ibatis.sboot.service;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/10/17 下午3:17
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
public enum EnumTest2 {

	TEST_01("0"),
	TEST_02("1"),
	TEST_03("2");

	@Getter
	@Setter
	private String value;

	EnumTest2(String value) {
		this.value = value;
	}
}
