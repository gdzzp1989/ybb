package ybb.algorithm;

import java.util.Stack;
//10进制转8进制
public class Conversion {
    public static void main(String[] args) {
        Stack s = new Stack();
        int num1= 1348;
        while(num1>0){
            s.push(num1%8);
            num1=num1/8;
        }
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
}
