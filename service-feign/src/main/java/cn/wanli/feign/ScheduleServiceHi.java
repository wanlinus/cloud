package cn.wanli.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wanli
 * @date 2019-01-22 16:47
 */
@FeignClient(value = "eureka-client", fallback = ScheduleServiceHiHiHystrix.class)
public interface ScheduleServiceHi {

    /**
     * @param name wanli
     * @return asd
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}

