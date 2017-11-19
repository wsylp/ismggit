package wsylp.ws.cxf;

import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**服务器
 * Created by wsylp on 2017/10/19.
 */
public class CXfServer {

    public static void main(String[] args) {
        //这边是两种发布方式
      /*  //JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        ServerFactoryBean factory = new ServerFactoryBean();
        factory.setAddress("http://localhost/ismg/wsylp/cxf/cxfService");
        factory.setServiceClass(CxfService.class);
        factory.setServiceBean(new CxfServiceImpl());
        factory.create();
        System.out.println("webservice已经进行发布");*/
    }

}
