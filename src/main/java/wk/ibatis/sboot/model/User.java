package wk.ibatis.sboot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/3/15 下午4:03
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
@Setter
@Getter
public class User {

	private static final long serialVersionUId = 1L;

	private String id;
	private String name;
}
