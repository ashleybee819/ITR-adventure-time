package org.ashley;

public class Clothing extends Item implements TenPercentTax {

    public Clothing() {
        super();
    }
    public Clothing(int i, String n, double p) {
        super(i, n, p);
    }
}