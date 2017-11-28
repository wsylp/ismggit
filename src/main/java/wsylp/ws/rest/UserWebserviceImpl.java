package wsylp.ws.rest;

import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import wsylp.po.User;
import wsylp.service.UserService;

//@Component
public class UserWebserviceImpl implements UserWebservice {

    @Autowired
    private UserService userService;

    @Override
    public List<User> getUser() {
        List<User> users =  userService.getUserList();
        return users;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User updateUserByLoginName(String name) {
        return null;
    }


    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUserById(long id, Map<String, Object> fieldMap) {
        return null;
    }

    @Override
    public User deleteUserById(long id) {
        return null;
    }
}
