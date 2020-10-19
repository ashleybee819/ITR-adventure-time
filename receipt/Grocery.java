package org.ashley;

public class Grocery extends Item implements FivePercentTax {

    public Grocery() {
        super();
    }
    public Grocery(int i, String n, double p) {
        super(i, n, p);
    }
}
