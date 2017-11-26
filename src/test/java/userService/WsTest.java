package userService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wsylp.ws.spring_cxf.SpringCxfService;

/**
 * Created by wsylp on 2017/10/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ismg/spring-*.xml"})
public class WsTest {

    @Autowired
    private SpringCxfService springCxfService;

    @Test
    public void testWs() {
        springCxfService.useSpringCxfService("我在测试.....");
    }
}
