package com.ch.commoninterface.domain;

import java.io.Serializable;

/**
 * @author chenhong
 * date 2024/1/8
 **/
public class UserAddress implements Serializable {
    private String address;

    public UserAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return address;
    }
}
