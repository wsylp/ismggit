package wsylp.log.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by wsylp on 2017/7/22.
 */
public class LogAdvisorAround implements MethodInterceptor {

    private static Logger logger = LogManager.getLogger(LogAdvisorAround.class.getName());

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        logger.info(
            "环绕增强开始=>" + methodInvocation.getMethod().getDeclaringClass() + "." + methodInvocation
                .getMethod().getName());
        Object obj = methodInvocation.proceed();

        //在目标执行后调用
        logger.info(
            "环绕增强结束=>" + methodInvocation.getMethod().getDeclaringClass() + "." + methodInvocation
                .getMethod().getName());
        return obj;
    }
}
