package wsylp.log.advisorC;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;


/**
 * Created by wsylp on 2017/7/17.
 */
public class LogBeforeAdvice implements MethodBeforeAdvice {

    private static Logger logger = LogManager.getLogger(LogBeforeAdvice.class.getName());

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.info("基于advisor->前置增强"+"方法名:" + o.getClass().getName() + "." + method.getName() + "()");
     }
}
