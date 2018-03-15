package wk.ibatis.sboot.service;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/9/7 下午4:41
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
public enum CarEnum {

    BMW("BMW"), TOYOTA("TOYOTA"), FIAT("FIAT");
    private String CarType;

    private CarEnum(String CarType) {
        this.CarType = CarType;
    }

    public String getCarType() {
        return CarType;
    }
}
