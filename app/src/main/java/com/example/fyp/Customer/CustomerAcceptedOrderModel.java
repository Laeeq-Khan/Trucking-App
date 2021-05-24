package com.example.fyp.Customer;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomerAcceptedOrderModel {

    private String driverName;
    private String imageView;
    private String driverMobile;
    private String requestId;
    private String driverId;

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderName() {
        return orderName;
    }

    private String orderName;

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setImageView(String  imageView) {
        this.imageView = imageView;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }

    public String getDriverName() {
        return driverName;
    }

    public String  getImageView() {
        return imageView;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setRequestId(String driverId) {
        this.requestId = driverId;
    }

    public String getRequestId() {
        return requestId;
    }

    public CustomerAcceptedOrderModel(String driverName, String  imageView, String driverMobile, String requestId,String driverId,String orderName) {
        this.driverName = driverName;
        this.imageView = imageView;
        this.driverMobile = driverMobile;
        this.requestId=requestId;
        this.driverId=driverId;
        this.orderName=orderName;
    }
}
