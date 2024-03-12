package com.ch.commoninterface.service;

import com.ch.commoninterface.domain.UserAddress;
import java.util.List;

/**
 * @author chenhong
 * date 2024/1/8
 **/
public interface UserService {

    public List<UserAddress> getUserAddressList(String userId);
}
