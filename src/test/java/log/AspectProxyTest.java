package log;


import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import wsylp.log.MyLog;
import wsylp.service.UserService;
import wsylp.service.impl.UserServiceImpl;

/**
 * Created by wsylp on 2017/7/22.
 */
public class AspectProxyTest {


 /*   @Test
    public void proxy(){
        UserService userService = new UserServiceImpl();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(userService);
        factory.addAspect(MyLog.class);
        UserService proxy = factory.getProxy();
        proxy.getUserLogin("admin","123456");
    }
*/


}
