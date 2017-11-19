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
import wsylp.po.Music;
import wsylp.po.User;
import wsylp.service.MusicService;
import wsylp.service.UserService;

/**
 * 音乐控制器
 * Created by wsylp on 2017/5/4.
 */
@Controller
public class MusciController extends BaseController {

    private static Logger logger = LogManager.getLogger(MusciController.class.getName());



    /**
     * 音乐流行榜
     * @throws IOException
     */
    @RequestMapping("/music_popular.html")
    public String musicPopular() throws IOException {
        try {

            List<Music> musics = musicService.getMusic();
            return "musicPopular";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
    @ResponseBody
    @RequestMapping("/music_getMusic.html")
    public void getMusic() throws  IOException{

        List<Music> musics = musicService.getMusic();
        HashMap<String,Object> map = new HashMap<>();
        map.put("data",musics);
        map.put("total",musics.size());
        String json = JSON.toJSONString(map);
        response.getWriter().write(json);
    }




    @Autowired
    private UserService userService;

    @Autowired
    private MusicService musicService;


}
