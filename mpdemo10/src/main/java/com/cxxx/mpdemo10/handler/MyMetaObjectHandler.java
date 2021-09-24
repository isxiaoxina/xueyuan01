package com.cxxx.mpdemo10.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;


import java.util.Date;

/**
 * @Package ：com.cxxx.mpdemo10.handler
 * @ClassName：MyMeatObiectHandler
 * @date ：2021/9/170:19
 * @Description：  自动填充mp方式 需要的类    要实现以下方法
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //第一个参数 字段名  第二个值   ，第三个元数据  就是metaobject

        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);

        this.setFieldValByName("version", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);

    }
}
