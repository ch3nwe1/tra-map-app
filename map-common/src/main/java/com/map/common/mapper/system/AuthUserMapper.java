package com.map.common.mapper.system;

import com.map.common.entity.system.AuthUser;
import org.springframework.stereotype.Repository;

/**
 * 系统用户数据库访问层
 * @author 陈伟
 * @date 2019/7/21 10:53
 **/
@Repository
public interface AuthUserMapper {

    /**
     * 通过主键查询系统用户
     * @param id 主键
     * @return 系统用户，如果没查到则返回 <code>null</code>
     */
    AuthUser getUserByKey(Long id);

    /**
     * 新增用户
     * @param authUser 用户实例
     * @return 返回数据库影响的记录数
     */
    int insertUser(AuthUser authUser);

    /**
     * 通过主键删除用户
     * @param id 用户编号
     * @return 返回影响数据库的记录数
     */
    int deleteUser(Long id);

    /**
     * 通过用户登录账号查询用户
     * @param code 用户账号
     * @return 用户实例
     */
    AuthUser getUserByCode(String code);
}
