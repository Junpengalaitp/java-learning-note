package com.junpenghe.solid.lsp;

import java.util.*;

public class PriceUtils {

    public static void main(String[] args) {

        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new InHouseProduct();

        List<Product> productList = new ArrayList<>();

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);

        for (Product product : productList) {
            System.out.println(product.getDiscount());
        }
    }

    Queue<Item> heap = new PriorityQueue<>(Comparator.comparing(Item::getCount).reversed());
}

class Item {
    private int value;
    private int count;

    public Item(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getValue() {
        return value;
    }
}
