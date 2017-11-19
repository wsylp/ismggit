package wsylp.controller;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wsylp.filter.Pagination;
import wsylp.filter.UserSearchFilter;
import wsylp.po.User;
import wsylp.service.UserService;

/**
 * Created by wsylp on 2017/5/4.
 */
@Controller
public class UserController extends BaseController {

    private static Logger logger = LogManager.getLogger(UserController.class.getName());




    /**
     * 注册用户
     */
    @RequestMapping("/register.html")
    public String register(User user) {
        userService.addUser(user);
        return "index";
    }

    @RequestMapping("/user_getLoginUser.html")
    public void getLoinUser() {

        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("user", user);
            String json = JSON.toJSONString(map);
           response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("/userList.html")
    public String userList() {
        return "userList";
    }


    @RequestMapping("/dashboard_2.html")
    public String dashboard() {
        return "dashboard_2";
    }

    @RequestMapping("/dashboard_3.html")
    public String dashboard3() {
        return "dashboard_3";
    }


    @RequestMapping("/login.html")
    public String login(User user) {
        User loginUser = userService.getUserLogin(user.getLoginName(), user.getPassword());
        if (loginUser != null) {
            logger.info("将用户存放到session中!");
            request.getSession().setAttribute("user", loginUser);
            return "index";
        } else {
            return "login";
        }
    }


    @RequestMapping("/user_getUserList")
    @ResponseBody
    public String getUserList() {
        try {
            String limit = request.getParameter("limit");
            String start = request.getParameter("start");
            String page = request.getParameter("page");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String workAddress = request.getParameter("workAddress");
            String workType = request.getParameter("workType");
            String level = request.getParameter("level");
            String realName = request.getParameter("realName");
            String loginName = request.getParameter("loginName");
            UserSearchFilter filter = new UserSearchFilter();
            filter.setLoginName(loginName);
            filter.setRealName(realName);
            if (!"".equals(StringUtils.trimToEmpty(level))) {
                filter.setLevel(Integer.parseInt(level));
            }

            filter.setWorkAddress(workAddress);
            filter.setWorkType(workType);
            Pagination pagination = new Pagination();
            if (!"".equals(StringUtils.trimToEmpty(limit))) {
                pagination.setLimit(Integer.parseInt(limit));
            }
            if (!"".equals(StringUtils.trimToEmpty(page))) {
                pagination.setPage(Integer.parseInt(page));
            }
            if (!"".equals(StringUtils.trimToEmpty(start))) {
                pagination.setStart(Integer.parseInt(start));
            }

            List<User> users = userService.getUserListByFP(filter, pagination);
            long count = userService.countGetUserListByFP(filter);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("data", users);
            map.put("total", count);
            String json = JSON.toJSONString(map);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("data", null);
            map.put("total", -1);
            String json = JSON.toJSONString(map);
            return json;
        }
    }


    @RequestMapping("/user_userList.html")
    public String myQuestionAndAnawer() {
        return "/user/userList";
    }

    /**
     * 返回首页
     */
    @RequestMapping("/ user_getHome")
    @ResponseBody
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @Autowired
    private UserService userService;


}
