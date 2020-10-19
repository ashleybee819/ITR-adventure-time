package org.ashley;

import java.io.Serializable;

public class Item implements Serializable {

    protected int id;
    protected String name;
    protected double price;

    public Item() {}

    public Item(int i, String n, double p) {
        this.id = i;
        this.name = n;
        this.price = p;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof Item)) {
            return false;
        }

        if (that == this) {
            return true;
        }

        Item temp = (Item)that;

        return this.id == temp.id && this.name.equals(temp.name) && this.price == temp.price;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price;
    }

    @Override
    public int hashCode() {
        return ((this.id * 87) + (this.name.length() + 44)) % 71;
    }
}
