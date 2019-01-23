package cn.wanli.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
    public String hello(@RequestParam String name) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        String hostName = addr.getHostName();
        return String.format("hello: %s<br />this docker ip:%s:%s <br />hostname:%s",
                name, ip, port, hostName);
    }
}
