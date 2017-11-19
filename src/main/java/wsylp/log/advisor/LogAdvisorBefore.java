package wsylp.log.advisor;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogAdvisorBefore implements MethodBeforeAdvice {
    private static Logger logger = LogManager.getLogger(LogAdvisorBefore.class.getName());

    public void before(Method method, Object[] args, Object target) throws Throwable {
        logger.info("前置增强:"+method.getDeclaringClass()+"."+method.getName());
    }
}
