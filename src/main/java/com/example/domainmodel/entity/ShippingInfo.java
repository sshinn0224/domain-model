package com.example.domainmodel.entity;

import com.example.domainmodel.entity.vo.Receiver;

public class ShippingInfo {
    private Receiver receiver;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipcode;

    public ShippingInfo(Receiver receiver, String shippingAddress1, String shippingAddress2, String shippingZipcode) {
        this.receiver = receiver;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingZipcode = shippingZipcode;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public String getShippingZipcode() {
        return shippingZipcode;
    }
}
