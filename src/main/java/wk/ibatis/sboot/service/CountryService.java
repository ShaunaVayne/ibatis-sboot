package wk.ibatis.sboot.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import wk.ibatis.sboot.mapper.CountryMapper;
import wk.ibatis.sboot.model.Country;

import java.util.List;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/25 下午3:35
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    public List<Country> getAll(Country country) {
        if(country.getPage() != null && country.getRows() != null) {
            PageHelper.startPage(country.getPage(),country.getRows());
        }
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if(country.getCountryname() != null && country.getCountryname().length() > 0) {
            criteria.andLike("countryname","%"+country.getCountryname()+"%");
        }
        if(country.getCountrycode() != null && country.getCountrycode().length() > 0) {
            criteria.andLike("countrycode","%"+country.getCountrycode()+"%");
        }
        return countryMapper.selectByExample(example);
    }

    public Country getById(Integer id) {
        return countryMapper.selectByPrimaryKey(id);
    }

    public void save(Country country) {
        if(country.getId() == null) {
            countryMapper.insert(country);
        }else {
            countryMapper.updateByPrimaryKey(country);
        }
    }
}
