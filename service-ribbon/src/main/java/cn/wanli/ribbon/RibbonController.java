package cn.wanli.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli
 * @date 2019-01-22 14:59
 */
@RestController
@RequestMapping
public class RibbonController {

    @Autowired
    private HelloService helloService;

    @GetMapping
    public String accessClient(@RequestParam String str) {
        return helloService.hiService(str);
    }
}
