package com.map.common.constant;

/**
 * 账户状态
 * @author 陈伟
 * @date 2019-07-22
 */
public enum AccountStatus {

    /**
     * 账户正常使用
     */
    Active("活跃"),
    /**
     * 账户被锁定
     */
    Lock("锁定"),
    /**
     * 账户失效
     */
    Invaild("失效");

    private String name;

    public String getName() {
        return name;
    }

    AccountStatus(String name) {
        this.name = name;
    }
}
