package com.junpenghe.solid.ocp.after;

import java.util.Collections;
import java.util.List;

public class HomeInsuranceCustomerProfile implements CustomerProfile {
    @Override
    public boolean isLoyalCustomer() {

        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 5);
        int r1 = Collections.binarySearch(list, 3);
        int r2 = Collections.binarySearch(list, 2);
        int r3 = Collections.binarySearch(list, 6);
        int r4 = Collections.binarySearch(list, 0);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        list.add(0, 2);
    }
}
