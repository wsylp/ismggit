package wsylp.ws.jdkPub;

import javax.jws.WebService;

/**
 * 实现接口
 * Created by wsylp on 2017/10/17.
 */
@WebService(
    serviceName = "JavaPublish",
    portName = "JavaPublishPort",
    endpointInterface = "wsylp.ws.jdkPub.JavaPublish"
)
public class JavaPublishImpl implements JavaPublish {

    @Override
    public void publish(String name) {
        System.out.println("我们使用java进行发布:" + name);
    }
}
