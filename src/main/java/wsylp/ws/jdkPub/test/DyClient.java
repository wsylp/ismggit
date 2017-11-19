package wsylp.ws.jdkPub.test;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import wsylp.ws.jdkPub.JavaPublish;


public class DyClient {

    public static void main(String[] args) {
        try {
            URL wsdl = new URL("http://localhost/ismg/wsylp/javaPub/javaPub?wsdl");
            QName serviceName = new QName("http://jdkPub.ws.wsylp/", "JavaPublish");
            QName portName = new QName("http://jdkPub.ws.wsylp/", "JavaPublishPort");
            Service service = Service.create(wsdl, serviceName);

            JavaPublish jp = service.getPort(portName, JavaPublish.class);
            jp.publish("哈哈");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
