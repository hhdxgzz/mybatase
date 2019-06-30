package com.itheima.dao;

import com.itheima.domain.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Mr_Zhao
 * @Description:
 * @Date: Create in  2019/6/17 10:52
 */
public interface CustDao {

    @Results(value = {
            @Result(property = "user.rolename", column = "rolename")
    })
    @Select({"<script>",
            "select * from s_cust c, s_user u where c.cust_link_user=u.uid",
            "<if test='cust_name!=null and cust_name!=\"\"'>and c.cust_name like concat('%',#{cust_name},'%')</if>",
            "<if test='cust_type!=null and cust_type!=\"\"'>and c.cust_type like concat('%',#{cust_type},'%')</if>",
            "</script>"})
    List<Customer> findAll(Customer customer);

    @Insert("insert into s_cust values(null,#{cust_name},#{cust_type},#{cust_phone},#{cust_address},#{user.uid})")
    Integer save(Customer customer);
    @Delete("delete from s_cust where cid = #{cid}")
    void delete(Integer cid);
}
