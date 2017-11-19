package wsylp.service;

import java.util.List;
import wsylp.filter.Pagination;
import wsylp.filter.UserSearchFilter;
import wsylp.po.Music;
import wsylp.po.User;

/**
 * Created by wsylp on 2017/5/4.
 */

public interface MusicService {

    /**
     * 查询所有音乐
     */
    List<Music> getMusic();


}
