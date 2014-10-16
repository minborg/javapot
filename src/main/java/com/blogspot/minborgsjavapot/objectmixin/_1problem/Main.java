package com.blogspot.minborgsjavapot.objectmixin._1problem;

/**
 *
 * @author pemi
 */
public class Main {

    public static void main(String[] args) {
        A a = new A(1);
        B b = new B(1, 2);

        System.out.println("a.equals(b) is " + a.equals(b));  // true
        System.out.println("b.equals(a) is " + b.equals(a));  // false
    }

}
