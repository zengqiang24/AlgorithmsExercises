package dynamicdemo;

public class Mulan extends Father{
    public int age = 20;
    public String sex = "女";

    @Override
    public void fight() {
        System.out.println("骑马杀敌！");
    }

    public void makeUp(){
        System.out.println("女人都爱美，喜欢化妆");
    }

    public static void eat(){
        System.out.println("吃蔬菜");
    }
}
