package com.cxxx.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author
 * @since 2018/12/13
 */
public class CodeGenerator {

    @Test
    public void run() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //建议绝对路径    （输出在哪里）  改
        gc.setOutputDir("H:\\ideawork\\guli_parent\\service\\service_edu" + "/src/main/java");


        gc.setAuthor("testjava");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService");	//去掉Service接口的首字母I

        gc.setIdType(IdType.ID_WORKER_STR); //主键策略  根据主键改
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(true);//开启Swagger2模式

        mpg.setGlobalConfig(gc);

        // 3、数据源配置   改自己的数据
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/xueyuan?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置   改
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("eduservice"); //模块名
        pc.setParent("com.cxxx");



        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("edu_teacher");  //表名称

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



    @Test
    public  void paixu(){
         int a[]={1,5,8,2};
         //int[] pp=new i
        int b=0;
        for (int i=1;i<a.length;i++){       //a.length是4   i<4   控制冒泡的次数  说白了就是把每个数都比一次
            //内循环 saiz-1       外循环是为了  每个数字都比较到
            for (int j=0;j<a.length-1;j++){//比较的次数比总长度要小1    比较3次
            if(a[j]>a[j+1]) {
                b = a[j];  //把大的存起来
               a[j]=a[j+1];  //把小的给第一个
               a[j+1]= b;//再把大 的给第二个   等于换位置
            }
            }

        }

        for (int i1 : a) {
            System.out.println(i1);
        }


    }
    @Test
    public  void maopao(){
        int a[]={1,4,55,7,5,23,56};
        for (int i=1;i<a.length;i++){//  比总数少一次比较
            for (int j=0;j<a.length;j++){
                int m;
                if (a[j]>a[j+1]){
                    m=a[j+1];
                    a[j+1]=a[j];
                    a[j+1]=m;
                }
            }
            for (int i1 : a) {
                System.out.println(i1);
            }
        }



    }







}
