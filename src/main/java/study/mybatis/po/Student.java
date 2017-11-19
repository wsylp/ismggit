package study.mybatis.po;

/**
 * Created by wsylp on 2017/10/29.
 */
public class Student {
    private int        studentId;
    private String     studentName;
    private int        studentAge;
    private String    studentPhone;

    public Student()
    {
        super();
    }

    public Student(int studentId, String studentName, int studentAge,
        String studentPhone)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentPhone = studentPhone;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public int getStudentAge()
    {
        return studentAge;
    }

    public void setStudentAge(int studentAge)
    {
        this.studentAge = studentAge;
    }

    public String getStudentPhone()
    {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone)
    {
        this.studentPhone = studentPhone;
    }

    public String toString()
    {
        return "StudentId:" + studentId + "\tStudentName:" + studentName +
            "\tStudentAge:" + studentAge + "\tStudentPhone:" + studentAge;
    }
}
