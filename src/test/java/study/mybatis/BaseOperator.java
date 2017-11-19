package study.mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by wsylp on 2017/10/29.
 */
public class BaseOperator {
    protected static SqlSessionFactory ssf;
    protected static Reader reader;

    static
    {
        try
        {
            reader = Resources.getResourceAsReader("test/config.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
