package wsylp.service.impl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsylp.dao.MusicMapper;
import wsylp.dao.UserMapper;
import wsylp.filter.Pagination;
import wsylp.filter.UserSearchFilter;
import wsylp.po.Music;
import wsylp.po.User;
import wsylp.service.MusicService;
import wsylp.service.UserService;


@Service("musicService")
public class MusicServiceImpl implements MusicService {

    @Autowired
    public UserMapper userDao;

    @Autowired
    public MusicMapper musicDao;


    public List<Music> getMusic() {
        List<Music> list = musicDao.getMusic();
        return list;
    }


}
