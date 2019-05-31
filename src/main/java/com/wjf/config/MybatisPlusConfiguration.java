package com.wjf.config;

import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * MybatisPlus 配置类
 *
 * @author weijunfeng
 * @date 2019/5/20 上午11:06
 */
@Configuration
@MapperScan("com.wjf.mapper")
public class MybatisPlusConfiguration {

    /**
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     *
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @author sunyue
     * @date 2019/1/16 上午10:55
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    /**
     * SQL执行效率插件
     *
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
     * @author sunyue
     * @date 2019/1/16 上午10:56
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * mybatis-plus逻辑删除插件
     *
     * @param
     * @return com.baomidou.mybatisplus.extension.injector.LogicSqlInjector
     * @author sunyue
     * @date 2019/1/16 上午10:58
     */
    @Bean
    public LogicSqlInjector logicSqlInjector() {
        return new LogicSqlInjector();
    }
}
