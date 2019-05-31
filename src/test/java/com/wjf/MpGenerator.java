package com.wjf;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MpGenerator {
    public static void main(String[] args) {
        String packageName="com.wjf";
        generateByTables(packageName,"user_info");
    }

    private static void generateByTables(String packageName,String... tableNames) {
        GlobalConfig config=new GlobalConfig();
        String dbUrl="jdbc:mysql://127.0.0.1:3306/gym";
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setCapitalMode(true);
        config.setActiveRecord(true)
                .setAuthor("weijunfeng")
                .setOutputDir("src/main/java")
                .setFileOverride(true);

        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(new PackageConfig()
                        .setParent(packageName)
                        .setController("controller")
                        .setEntity("entity"))
                .execute();


    }
}
