package wsylp.dao;

import java.util.List;
import wsylp.filter.Pagination;
import wsylp.filter.UserSearchFilter;
import wsylp.po.User;

/**
 * Created by wsylp on 2017/5/30.
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(T pk);

    int insert(T obj);

    int insertSelective(T obj);

    T selectByPrimaryKey(Object pk);

    int updateByPrimaryKeySelective(T obj);

    int updateByPrimaryKey(T obj);

}
