package cn.wanli.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wanli
 * @date 2019-01-22 14:41
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name=" + name, String.class);
    }
}
