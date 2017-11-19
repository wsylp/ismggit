package study.base;

import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wsylp on 2017/9/25.
 */
public class ArraySortTest {

    public static void main(String[] args) {

        Dog dog1 = new Dog();
        dog1.setAge(2);
        dog1.setName("小狗");
        Dog dog2 = new Dog();
        dog2.setAge(3);
        dog2.setName("大狗");

        Dog[] dogArray = {dog1, dog2};


        Arrays.sort(dogArray,new Dog());

        //sort(dogs);

        for(Dog d : dogArray){
            System.out.println(d.getAge()+":" + d.getName());
            System.out.println();
        }

    }

}
