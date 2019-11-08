package cn.swallow.oauth.common.util;

import org.apache.commons.lang.math.RandomUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 * @author Administrator
 * @description
 * @create 2019/5/29
 */
public class IdGenUtil {

    private static final long LIMIT = 10000000000L;
    private volatile static long last = 0;

    private static SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator.Factory().create(1,1);

    public static Long nextId(){
        return snowFlakeGenerator.nextId();
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成10位线性增长用户ID
     */
    public static long getUid() {
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= last ) {
            id = (last + 1) % LIMIT;
        }
        return last = id;
    }

    public static String nextOrderId(){
        LocalDateTime localDateTime = LocalDateTime.now();
        String baseStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String suffix = String.valueOf(RandomUtils.nextInt(new Random(1000),10000));
        return baseStr + suffix;
    }

    public static void main(String[] args){
        System.out.println(nextOrderId());
    }

}
