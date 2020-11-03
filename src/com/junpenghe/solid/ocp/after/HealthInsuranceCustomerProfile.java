package com.junpenghe.solid.ocp.after;

public class HealthInsuranceCustomerProfile implements CustomerProfile {
    @Override
    public boolean isLoyalCustomer() {
        return true;
    }
}
