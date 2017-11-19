package wsylp.log.advisorC;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

/**
 * Created by wsylp on 2017/7/23.
 */
public class LogAfterAdvice implements AfterReturningAdvice {

    private static Logger logger = LogManager.getLogger(LogAfterAdvice.class.getName());

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object target)
        throws Throwable {
        logger.info(
            "基于advisor->后置增强" + "方法名:" + target.getClass().getName() + "." + method.getName() + "()");
    }
}
