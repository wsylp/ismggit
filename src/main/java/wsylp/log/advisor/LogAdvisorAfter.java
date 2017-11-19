package wsylp.log.advisor;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

/**
 * Created by wsylp on 2017/7/22.
 */
public class LogAdvisorAfter implements AfterReturningAdvice {
    private static Logger logger = LogManager.getLogger(LogAdvisorAfter.class.getName());

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1)
        throws Throwable {
        logger.info("后置增强:"+method.getDeclaringClass()+"."+method.getName());
    }
}
