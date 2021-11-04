package com.wjh.mapper;

import com.wjh.entity.Admin;

/**
 * @author wjh
 * @date 2021/11/4 9:27 下午
 */
public interface AdminMapper {

    /**
     * 登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}
