package study.mybatis.mapper;

import java.util.List;
import study.mybatis.po.Student;

/**
 * Created by wsylp on 2017/10/29.
 */
public interface StudentMapper {
    Student selectStudentById(int id);
    List<Student> selectList();
    List<Student>  selectAll();
}
