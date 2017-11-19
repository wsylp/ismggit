package wsylp.ws.jdkPub;


import javax.xml.ws.Endpoint;

/**
 * 用来发布WebService的服务端
 * Created by wsylp on 2017/10/17.
 */
public class Server {

    public static void main(String[] args) {
        //ws的服务地址,可以在浏览器中直接输入该地址,http://localhost/ismg/wsylp/javaPub/javaPub?wsdl
        String adress = "http://localhost/ismg/wsylp/javaPub/javaPub";
        JavaPublish javaPublish = new JavaPublishImpl();

        Endpoint.publish(adress,javaPublish);
        System.out.println("webservice 已经发布.....");
    }
}
