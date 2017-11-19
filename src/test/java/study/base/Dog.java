package study.base;

import java.util.Comparator;

/**
 * Created by wsylp on 2017/9/25.
 */
public class Dog implements Comparable, Comparator<Dog> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return ((Dog)o).getAge() - this.getAge();
    }


    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getAge() - o2.getAge();
    }
}
