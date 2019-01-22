package cn.wanli.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli
 * @date 2019-01-22 17:00
 */
@RestController
@RequestMapping
public class FeignController {

    @Autowired
    private ScheduleServiceHi hi;

    @GetMapping
    public String fi(@RequestParam(defaultValue = "default") String name) {
        return hi.hello(name);
    }
}
