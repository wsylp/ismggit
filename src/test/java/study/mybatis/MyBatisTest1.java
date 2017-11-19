package study.mybatis;

import java.util.List;
import study.mybatis.po.Student;

/**
 * Created by wsylp on 2017/10/29.
 */
public class MyBatisTest1 {

    public static void main(String[] args) {
        //System.out.println(StudentOperator.getInstance().selectStudentById(1));
       // selectList();
        selectAll();
    }

    private static void selectAll() {
        List<Student> students = StudentOperator.getInstance().selectAll();
        System.out.println(students.size());
    }

    private static void selectList() {
        List<Student> students = StudentOperator.getInstance().selectList();

        System.out.println(students.size());
    }
}
