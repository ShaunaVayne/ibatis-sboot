package wk.ibatis.sboot.util;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/12 下午6:50
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T>{
}
