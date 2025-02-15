package main.java.com.maman12.q1;

import java.util.ArrayList;
import java.util.List;

//Represents a polynomial and provides operations on polynomials.
public class Polynom {

    private List<PolynomElement> list = new ArrayList<>();

    //Initializes a polynomial with given coefficients and powers
    public Polynom(double[] coefficient, int[] power) throws Exception {
        init(coefficient, power);
    }

    private Polynom(List<PolynomElement> list) {
        this.list = list;
    }

    //Initializes the polynomial based on the given coefficients and powers
    private void init(double[] coefficient, int[] power) throws Exception {
        sort(power);
        if(coefficient.length != power.length)
            throw new Exception("Arrays lengths are not equal!");
        for (int i = 0; i < coefficient.length; i++) {
            list.add(new PolynomElement(coefficient[i], power[i]));
        }
    }

    public Polynom plus(Polynom q) throws Exception {
        return arithmeticOperation(q, Operator.PLUS);
    }

    public Polynom minus(Polynom q) throws Exception {
        return arithmeticOperation(q, Operator.MINUS);
    }

    //Computes the sum and subtraction of two polynomials
    private Polynom arithmeticOperation(Polynom q, Operator op) throws Exception {
        List<PolynomElement> resultList = new ArrayList<>();

        int i = 0, j = 0;
        while(i < this.list.size() && j < q.getList().size()) { // Change the condition here
            int iPower = this.list.get(i).getPower();
            int jPower = q.getList().get(j).getPower();

            if(iPower < jPower) {
                double co = q.getList().get(j).getCoefficient();
                resultList.add(new PolynomElement(op == Operator.MINUS ? co * -1 : co, jPower));
                j++;
            } else if (iPower > jPower) {
                double co = this.list.get(i).getCoefficient();
                resultList.add(new PolynomElement(op == Operator.MINUS ? co * -1 : co, iPower));
                i++;
            } else {
                double co;
                switch (op) {
                    case PLUS:
                        co = this.list.get(i).getCoefficient() + q.getList().get(j).getCoefficient();
                        break;
                    case MINUS:
                        co = this.list.get(i).getCoefficient() - q.getList().get(j).getCoefficient();
                        break;
                    default:
                        throw new Exception("Wrong operator!");
                }
                resultList.add(new PolynomElement(co, iPower));
                i++;
                j++;
            }
        }

        // Handle remaining elements in one of the lists
        while (i < this.list.size()) {
            double co = this.list.get(i).getCoefficient();
            resultList.add(new PolynomElement(op == Operator.MINUS ? co * -1 : co, this.list.get(i).getPower()));
            i++;
        }

        while (j < q.getList().size()) {
            double co = q.getList().get(j).getCoefficient();
            resultList.add(new PolynomElement(op == Operator.MINUS ? co * -1 : co, q.getList().get(j).getPower()));
            j++;
        }

        return new Polynom(resultList);
    }

    //Computes derivative of the current polynom
    public Polynom derivative() {
        List<PolynomElement> derivativeList = new ArrayList<>();

        for (PolynomElement element : list) {
            double originalCoefficient = element.getCoefficient();
            int originalPower = element.getPower();

            // Compute the derivative
            double derivativeCoefficient = originalCoefficient * originalPower;
            int derivativePower = originalPower - 1;

            // Add the derivative term to the result list
            if (derivativePower >= 0) {
                derivativeList.add(new PolynomElement(derivativeCoefficient, derivativePower));
            }
        }

        return new Polynom(derivativeList);
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < list.size(); i++) {
            PolynomElement element = list.get(i);

            // Append the coefficient
            double coefficient = element.getCoefficient();
            if(coefficient != 0) {
                if(i > 0) {
                    result.append(coefficient > 0 ? "+" : "-");
                } else if(coefficient < 0) {
                    result.append("-");
                }

                // Handle the case where the absolute value of the coefficient is not 1
                if(Math.abs(coefficient) != 1 || element.getPower() == 0) {
                    result.append(Math.abs(coefficient));
                }

                // Append the variable (x) if the power is greater than 0
                if(element.getPower() > 0) {
                    result.append("x");

                    // Append the power if greater than 1
                    if(element.getPower() > 1) {
                        result.append("^").append(element.getPower());
                    }
                }
            }
        }

        if(result.length() == 0) {
            return "0";  // Return "0" if the polynomial is zero
        }
        return result.toString();
    }

    //Checks if two polynomials are equal
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass() || this.list.size() != ((Polynom)obj).getList().size())
            return false;
        Polynom other = (Polynom)obj;
        boolean res = false;
        int i = 0;
        while(i < this.list.size()) {
            res = this.list.get(i).equals(other.getList().get(i));
            i++;
        }
        return res;
    }


    private void sort(int[] power) {
        // Sorting the power array in descending order
        for(int i = 0; i < power.length - 1; i++) {
            for(int j = 0; j < power.length - 1 - i; j++) {
                if(power[j] < power[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = power[j];
                    power[j] = power[j + 1];
                    power[j + 1] = temp;
                }
            }
        }
    }

    private List<PolynomElement> getList() {
        return list;
    }
}



//Represents an element of a polynomial with a coefficient and power
class PolynomElement {
    private double coefficient;
    private int power;

    public PolynomElement(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "PolynomElement{" +
                "coefficient=" + coefficient +
                ", power=" + power +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        PolynomElement other = (PolynomElement)obj;
        return Double.compare(this.coefficient, other.getCoefficient()) == 0 && this.power == other.getPower();
    }
}