package com.example.domainmodel.entity;

import com.example.domainmodel.entity.vo.Money;

import java.util.List;

public class Order {
    private String orderNumber;
    private OrderState state;
    private List<OrderLine> orderLines;
    private ShippingInfo shippingInfo;
    private Orderer orderer;
    private Money totalAmounts;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo, Orderer orderer) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();

    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if(shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;

    }

    private void setOrderer(Orderer orderer) {
        if(orderer == null) throw new IllegalArgumentException("no orderer");
        this.orderer = orderer;
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        this.shippingInfo = newShippingInfo;
    }

    private void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        if(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
            throw new IllegalStateException("already shipped");

    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if(orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .mapToInt(x -> x.getAmounts().getValue())
                .sum();
        this.totalAmounts = new Money(sum);

    }


    public enum OrderState {
        PAYMENT_WAITING,
        PREPARING,
        SHIPPED, DELIVERING, DELIVERY_COMPLETED,
        CANCELED;

    }
}
