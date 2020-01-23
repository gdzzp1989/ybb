package ybb.algorithm;

public class Hanio {

    static int step = 0;

    public static void main(String[] args) {
        //汉诺塔
        hanio(4, "A", "B", "C");
    }

    public static void hanio(int num, String a, String b, String c) {
        if (num == 1) {
            move(num, a, c);
        } else {
            hanio(num - 1, a, c, b);
            move(num, a, c);
            hanio(num - 1, b, a, c);
        }
    }

    public static void move(int num, String a, String b) {
        step++;
        System.out.println("第" + step + "步，盘子" + num + "从" + a + "塔移到" + b + "塔");

    }
}
