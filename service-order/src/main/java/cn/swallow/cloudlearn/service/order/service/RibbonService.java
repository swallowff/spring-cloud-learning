package cn.swallow.cloudlearn.service.order.service;

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

    @HystrixCommand(fallbackMethod = "doTestError")
    public String doTest(String name) {
        return restTemplate.getForObject("http://service-one/api/doTest?name="+name,String.class);
    }

    public String doTestError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
