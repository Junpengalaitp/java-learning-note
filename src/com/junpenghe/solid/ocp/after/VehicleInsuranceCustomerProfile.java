package com.junpenghe.solid.ocp.after;

public class VehicleInsuranceCustomerProfile implements CustomerProfile {
    @Override
    public boolean isLoyalCustomer() {
        return true;
    }
}
