package org.ppp.model;

import java.io.Serializable;

/**
 * @author thinking_fioa
 * @createTime 2018/5/5
 * @description
 */

public class Order implements Serializable {
    private String OrderNo;
    private String itemCode;
    private String itemName;
    private Long quantity;

    public String getOrderNo() {
        return OrderNo;
    }
    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }
    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
