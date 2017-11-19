package wsylp.ws.cxf;

import javax.jws.WebService;

/**
 * Created by wsylp on 2017/10/19.
 */
//@WebService
public class CxfServiceImpl implements CxfService {

    @Override
    public void useCxfService(String name) {
        System.out.println("useCxf发布webservice:" + name);
    }
}
