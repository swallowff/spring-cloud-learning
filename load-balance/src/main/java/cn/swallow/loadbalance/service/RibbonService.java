package cn.swallow.loadbalance.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author swallowff
 * @create 2019/10/9
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "goodsListError")
    public String goodsList() {
        return restTemplate.getForObject("http://service-goods/api/goodsList",String.class);
    }

    public String goodsListError() {
        return "Ribbon hystrix error ! Service-goods is um-useful now ! Please try again later";
    }
}
