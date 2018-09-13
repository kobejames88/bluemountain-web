package com.bluemoutain.service;



import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.ext.SystemOrderExt;
import com.bluemoutain.utils.PageBean;

import java.util.Date;
import java.util.List;

public interface OrderService {

    int createOrder(SystemOrder order);

    SystemOrder findOrderById(Integer id);

    void updateOrder(SystemOrder order);

    void deleteOrder(Integer orderid);

    SystemOrder findOrderByOutOrderId(String id);

    PageBean<SystemOrder> findByPage(Integer page, Integer rows);

    PageBean<SystemOrderExt> findByPage2(Integer page, Integer rows, Integer uid, Integer status, Integer payType, String outOrderId, Integer order_type, Integer oid);

    List<SystemOrder> findOrderByStatus(Integer status);

    List<SystemOrder> findOrderByStatus(Integer status, Integer sett);

    Integer countOrderPayType(Integer payType, Date timelike);

    List<SystemOrder> findOrderList2(Integer status, Integer is_notify, Integer order_type);

}
