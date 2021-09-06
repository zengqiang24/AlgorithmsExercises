package dynamicdemo;

public class BattleField {
    public static void main(String[] args) {
        Father father = new Mulan();
        //自我介绍
        System.out.println("age:" + father.age);
        System.out.println("sex:" + father.sex);


        Father.eat();
        father.fight();

//        father.makeup();
        Mulan mulan = (Mulan) father;
        mulan.makeUp();
    }
}
