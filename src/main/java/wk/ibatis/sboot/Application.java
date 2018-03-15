package wk.ibatis.sboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/12 下午6:09
 * @ProjectName: ibatis-sboot
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableWebMvc
@Controller
@MapperScan(basePackages = "wk.ibatis.sboot.mapper")
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    /*@RequestMapping("/")
    public String foo() {
        return "redirect:countries";
    }*/
}
