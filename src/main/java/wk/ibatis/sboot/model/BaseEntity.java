package wk.ibatis.sboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/25 下午3:40
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
@Setter
@Getter
public class BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;


}
