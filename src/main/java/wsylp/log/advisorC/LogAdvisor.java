package wsylp.log.advisorC;

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import wsylp.service.impl.UserServiceImpl;

/**
 * Created by wsylp on 2017/7/17.
 */
public class LogAdvisor extends StaticMethodMatcherPointcutAdvisor{


    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return true;
    }
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return UserServiceImpl.class.isAssignableFrom(aClass);
            }
        };
    }
}
