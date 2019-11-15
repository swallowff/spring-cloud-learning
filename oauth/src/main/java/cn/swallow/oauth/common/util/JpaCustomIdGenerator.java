package cn.swallow.oauth.common.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * @author swallowff
 * @create 2019/9/18
 */
public class JpaCustomIdGenerator extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        Object id = IdGenUtil.nextId();
        if (null != id){
            return (Serializable) id;
        }
        return super.generate(s, obj);
    }

}
