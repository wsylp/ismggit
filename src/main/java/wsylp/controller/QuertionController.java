package wsylp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wsylp.service.UserService;

/**
 * Created by wsylp on 2017/5/4.
 */
@Controller
public class QuertionController extends BaseController {

    private static Logger logger = LogManager.getLogger(QuertionController.class.getName());




    @RequestMapping("/question_myQuestions.html")
    public String myQuestionAndAnawer(){
        return "/question/myQuestion";
    }

    @Autowired
    private UserService userService;


}
