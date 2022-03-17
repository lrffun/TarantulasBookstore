package com.tb.dao;

import com.tb.domain.Administrator;
import org.apache.ibatis.annotations.Select;

public interface IAdministratorDao {

    /**
     * 管理员登录
     * @param administrator
     * @return
     */
    @Select("select * from administrator where id=#{id} and password=#{password}")
    Administrator login(Administrator administrator);
}
