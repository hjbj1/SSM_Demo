package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface OrderDao {
    /**
     * 查询所有订单信息
     * @return
     */

    @Select("select * from orders")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "com.itheima.dao.ProductDao.findById"))
    })
    List<Order> findAll() throws Exception;



    @Select("select * from orders where id = #{id}")
    @Results({@Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productid",property = "product",one = @One(select = "com.itheima.dao.ProductDao.findById")),
            @Result(column = "memberid",property = "member",one = @One(select = "com.itheima.dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select = "com.itheima.dao.TravellerDao.findById"))
    })
    Order findById(String id) throws Exception;

}
