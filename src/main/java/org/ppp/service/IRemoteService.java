package org.ppp.service;

import org.ppp.model.Order;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @author thinking_fioa
 * @createTime 2018/5/5
 * @description
 */

//@WebService
public interface IRemoteService {
    public String showRemoteMessage(@WebParam(name="arg0") String message);

    public String addOrder(List<Order> orders);
}
