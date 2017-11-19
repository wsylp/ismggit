package wsylp.dao;


import java.util.List;
import wsylp.po.Music;

public interface MusicMapper extends BaseMapper<Music> {

   List<Music> getMusic();
}