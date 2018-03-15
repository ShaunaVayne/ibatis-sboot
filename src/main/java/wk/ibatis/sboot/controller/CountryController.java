package wk.ibatis.sboot.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import wk.ibatis.sboot.model.Country;
import wk.ibatis.sboot.service.CountryService;

import java.util.List;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/25 下午3:33
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping
    public ModelAndView getAll(Country country) {
        ModelAndView result = new ModelAndView("index");
        List<Country> countryList = countryService.getAll(country);
        result.addObject("pageInfo",new PageInfo<Country>(countryList));
        result.addObject("queryParam",country);
        result.addObject("page",country.getPage());
        result.addObject("rows",country.getRows());
        return result;
    }

    @RequestMapping(value = "/add")
    public ModelAndView add(Country country){
        ModelAndView result = new ModelAndView("view");
        result.addObject("country",new Country());
        return result;
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable Integer id) {
        ModelAndView resulut = new ModelAndView("view");
        Country country =  countryService.getById(id);
        resulut.addObject("country",country);
        return resulut;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(Country country) {
        ModelAndView resulut = new ModelAndView("view");
        String msg = country.getId() == null ? "新增成功" : "更新成功";
        countryService.save(country);
        resulut.addObject("msg",msg);
        resulut.addObject("country",country);
        return resulut;
    }




}
