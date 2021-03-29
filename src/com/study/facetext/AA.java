package com.study.facetext;

/**
 * @author jianghui
 * @date 2021-03-29 22:59
 */
public class AA {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }
}

class ExampleA extends Exception {
}

class ExampleB extends ExampleA {

    public ExampleB(String b) {

    }
}

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}
