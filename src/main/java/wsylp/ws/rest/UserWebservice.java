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
import wsylp.po.User;

/**
 * rest方式进行webservice
 * Created by wsylp on 2017/10/22.
 *
 *
 * 请求方式注解，包括：@GET、@POST、@PUT、@DELETE
 * 请求路径注解，包括：@Path，其中包括一个路径参数
 * 数据格式注解，包括：@Consumes（输入）、@Produces（输出），可使用 MediaType 常量
 * 相关参数注解，包括：@PathParam（路径参数）、@FormParam（表单参数），此外还有 @QueryParam（请求参数）
 * GET用来获取资源，
 * POST用来新建资源（也可以用于更新资源），
 * PUT用来更新资源，
 * DELETE用来删除资源。
 */

public interface UserWebservice {

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    List<User> getUser();

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    User getUserById(@PathParam("id") long id);

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    User updateUserByLoginName(@FormParam("loginName") String name);

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    User createUser(User user);

    @PUT
    @Path("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    User updateUserById(@PathParam("id") long id, Map<String, Object> fieldMap);

    @DELETE
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    User deleteUserById(@PathParam("id") long id);
}
