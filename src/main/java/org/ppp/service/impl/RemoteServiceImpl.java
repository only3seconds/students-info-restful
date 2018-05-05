package org.ppp.service.impl;

import com.alibaba.fastjson.JSONArray;
import org.ppp.model.Order;
import org.ppp.service.IRemoteService;

import javax.jws.WebService;
import java.util.List;

/**
 * @author thinking_fioa
 * @createTime 2018/5/5
 * @description
 */

@WebService(endpointInterface="org.ppp.service.IRemoteService")
public class RemoteServiceImpl implements IRemoteService {

    @Override
    public String showRemoteMessage(String message) {
        return "You message is "+ message;
    }

    @Override
    public String addOrder(List<Order> orders) {
        return JSONArray.toJSONString(orders,true);
    }
}
