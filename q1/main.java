package main.java.com.maman12.q1;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        ArrayList<Polynom> twoPolynonms = new ArrayList<>();

        for(int i = 0; i < 2; i++) {
            System.out.println("Please enter your " + (i+1) + " polynomial size: ");
            int polSize = scan.nextInt();

            double[] co = new double[polSize];
            int[] pow = new int[polSize];

            for(int j = 0; j < polSize; j++) {
                System.out.println("Please enter your " + (j + 1) + " coefficient: ");
                double coInput = scan.nextDouble();
                co[j] = coInput;

                System.out.println("Please enter your " + (j + 1) + " power: ");
                int powInput = scan.nextInt();
                pow[j] = powInput;
            }
            twoPolynonms.add(new Polynom(co, pow));
        }

        Polynom firstPol = twoPolynonms.get(0);
        Polynom secondPol = twoPolynonms.get(1);


        System.out.println("1st polynom:" + firstPol);
        System.out.println("2st polynom:" + secondPol);

        System.out.println("The sum of the two polynomials is:\n" + firstPol.plus(secondPol));
        System.out.println("The subtraction of the two polynomials is:\n" + firstPol.minus(secondPol));
        System.out.println("The derivative of the first polynomial is:\n" + firstPol.derivative());
        System.out.println("The derivative of the second polynomial is:\n" + secondPol.derivative());
        System.out.println("Are the polynomials equals?\n" + firstPol.equals(secondPol));
    }
}