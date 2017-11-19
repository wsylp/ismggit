package wsylp.log.schema;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by wsylp on 2017/7/23.
 */
public class LogSchema {

    private static Logger logger = LogManager.getLogger(LogSchema.class.getName());

    public void logBefore(JoinPoint point) {

        logger.info(
            "前置增强：" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature()
                .getName());
    }

    public void logAfter(JoinPoint point) {
        logger.info(
            "后置增强：" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature()
                .getName());
    }

    //环绕增强对应方法
    public void logAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("环绕增强开始:"+pjp.getSignature().getDeclaringTypeName()+"."+pjp.getSignature().getName());
        pjp.proceed();
        logger.info("环绕增强结束:"+pjp.getSignature().getDeclaringTypeName()+"."+pjp.getSignature().getName());
    }

    //抛出异常增强
    public void afterThrowingMethod(IllegalArgumentException iae) {
        System.out.println("----afterThrowingMethod()----");
        System.out.println("exception msg:" + iae.getMessage());
        System.out.println("----afterThrowingMethod()----");
    }

    //final增强
    public void afterMethod() {
        System.out.println("----afterMethod()----");
    }


}
