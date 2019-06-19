package com.itheima.dao;

import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {


    @Select("select * from traveller where id in (select travellerid from order_traveller where orderid = #{orderid})")
    List<Traveller> findById(String orderid) throws Exception;
}
