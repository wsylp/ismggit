package study.base.init;

/**
 * Created by wsylp on 2017/11/5.
 */
public class Mugs {

    Mug mug1;
    Mug mug2;
    static Mug mug3 ;
    static {
        mug3 = new Mug(3);
    }

    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1 & mug2 inittailzed");
    }
    Mugs(){
        System.out.println("Mugs()");
    }
    Mugs(int i){
        System.out.println("mugs(int)");
    }

    public static void main(String[] args) {
        new Mugs();
        System.out.println("11111111111111111111");
        new Mugs(1);
        int[] a = new int[2];

    }



}
