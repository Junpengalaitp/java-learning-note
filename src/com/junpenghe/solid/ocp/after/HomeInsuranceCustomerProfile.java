package com.junpenghe.solid.ocp.after;

public class HomeInsuranceCustomerProfile implements CustomerProfile {
    @Override
    public boolean isLoyalCustomer() {
        return true;
    }
}
