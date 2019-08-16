package com.map.zdx.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ConfigurationProperties
@ComponentScan(basePackages = {"com.map.zdx"})
public class MapAutoConfigure {
}
