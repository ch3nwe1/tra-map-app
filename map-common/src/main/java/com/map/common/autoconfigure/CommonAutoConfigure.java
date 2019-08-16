package com.map.common.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陈伟
 * @date 2019/8/3 11:06
 **/
@Configuration
@MapperScan(basePackages = {"com.map.common.mapper"})
public class CommonAutoConfigure {
}
