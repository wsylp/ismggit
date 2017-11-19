package wsylp.ws.spring_cxf;

import javax.jws.WebService;
import org.springframework.stereotype.Component;

/**
 * Created by wsylp on 2017/10/19.
 */
@WebService
@Component
public class SpringCxfServiceImpl implements SpringCxfService {

    @Override
    public void useSpringCxfService(String name) {
        System.out.println("使用spring与cxf进行使用wenservice:" + name);
    }
}
