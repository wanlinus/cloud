package cn.wanli.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli
 * @date 2019-01-22 14:23
 */
@RestController
@RequestMapping
public class ClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String port() {
        return "this application port is: " + port;
    }

    @GetMapping("hello")
    public String hello(@RequestParam String name) {
        return "hello: " + name + "<br />this application port is: " + port;
    }
}
