package com.tcsoft.service01;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author WMY
 */
public class CodeGenerator {

    public static void main(String[] args) {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("WMY");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        gc.setIdType(IdType.ID_WORKER_STR); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(false);//开启Swagger2模式

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://106.14.77.81:3306/sample?serverTimezone=Asia/Shanghai&userUnicode=true&CharacterEncoding=utf-8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("TCsoft123..");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //模块名
        pc.setParent("com.tcsoft.service01");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("WOR_ProgItem", "WOR_Result", "WOR_ResultRerun", "WOR_SampleInfo");
//        strategy.setInclude("BSC_ActionCode", "BSC_AgeType", "BSC_ComparisonInfo",
//                "BSC_ComparisonType", "BSC_DataType", "BSC_HospitalInfo", "BSC_Instrument",
//                "BSC_InstrumentAlternateType", "BSC_InstrumentGroup", "BSC_InstrumentType",
//                "BSC_PatientType", "BSC_PrepLinkAbortCode", "BSC_PrepLinkErrorCode",
//                "BSC_ResultRange", "BSC_ResultType", "BSC_ResultUnit", "BSC_Rule",
//                "BSC_RuleFunction", "BSC_RuleGroup", "BSC_RuleParam", "BSC_RuleType",
//                "BSC_SampleEvent", "BSC_SampleEventDisplay", "BSC_SampleStatus",
//                "BSC_SampleStatusDisplay", "BSC_SampleType", "BSC_SexType",
//                "BSC_TestItemDeltaCheck", "BSC_TestItemDuplicate", "BSC_TestItemGroup",
//                "BSC_TestItemGroupItem", "BSC_TestItemInfo", "BSC_TestItemType",
//                "BSC_TestType");//对那一张表生成代码
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}
