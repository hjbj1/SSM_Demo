package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    /**
     * 查询所有产品信息
     * @return
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 保存产品信息
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values " +
            "(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product) throws Exception;



    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
}
