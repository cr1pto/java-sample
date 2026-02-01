package com.cr1pto.sample.responses;

import java.math.BigDecimal;

public class StoreResponse {
    private String storeNumber;
    private String storeManager;
    private BigDecimal revenue;
    private BigDecimal totalCostOfGoodsSold;
    private BigDecimal totalLosses;
    private String state;
    private String city;

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(String storeManager) {
        this.storeManager = storeManager;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getTotalCostOfGoodsSold() {
        return totalCostOfGoodsSold;
    }

    public void setTotalCostOfGoodsSold(BigDecimal totalCostOfGoodsSold) {
        this.totalCostOfGoodsSold = totalCostOfGoodsSold;
    }

    public BigDecimal getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(BigDecimal totalLosses) {
        this.totalLosses = totalLosses;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
