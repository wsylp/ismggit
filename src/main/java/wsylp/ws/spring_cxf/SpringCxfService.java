package wsylp.ws.spring_cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by wsylp on 2017/10/19.
 */


@WebService
public interface SpringCxfService {
    @WebMethod
    void useSpringCxfService(String name);
}
