package cn.wanli.feign;

import org.springframework.stereotype.Component;

/**
 * @author wanli
 * @date 2019-01-23 16:38
 */
@Component
public class ScheduleServiceHiHiHystrix implements ScheduleServiceHi {

    @Override
    public String hello(String name) {
        return "Sorry this feign is down";
    }
}
