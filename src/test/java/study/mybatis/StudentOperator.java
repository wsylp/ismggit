package study.mybatis;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import study.mybatis.po.Student;

/**
 * Created by wsylp on 2017/10/29.
 */
public class StudentOperator extends BaseOperator {
    private static StudentOperator instance = new StudentOperator();

    private StudentOperator()
    {

    }

    public static StudentOperator getInstance()
    {
        return instance;
    }

    public Student selectStudentById(int studentId)
    {
        SqlSession ss = ssf.openSession();
        Student student = null;
        try
        {
            student = ss.selectOne("study.mybatis.mapper.StudentMapper.selectStudentById", 1);
        }
        finally
        {
            ss.close();
        }
        return student;
    }

    public  List<Student> selectList()
    {
        SqlSession ss = ssf.openSession();
        List<Student> students = null;
        try
        {
            students = ss.selectList("study.mybatis.mapper.StudentMapper.selectList", 1);
        }
        finally
        {
            ss.close();
        }
        return students;
    }

    public  List<Student> selectAll()
    {
        SqlSession ss = ssf.openSession();
        List<Student> students = null;
        try
        {
            students = ss.selectList("study.mybatis.mapper.StudentMapper.selectAll");
        }
        finally
        {
            ss.close();
        }
        return students;
    }
}
