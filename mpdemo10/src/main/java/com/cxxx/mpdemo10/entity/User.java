package com.cxxx.mpdemo10.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @Package ：com.cxxx.mpdemo10.entity
 * @ClassName：User
 * @date ：2021/9/1522:40
 * @Description：
 */

@Data
public class User {

    //@TableId(type = IdType.AUTO)  主键策略
    //1 auto 自动增长 2 uuid 随机  3 redis  4 这个mp的雪花算法默认策略
    private  Long id;
    private  String name;
    private  Integer age;
    private  String email;
//自动填充         fieldfill=字段填充

@TableField(fill = FieldFill.INSERT )
    private Date createTime;

@TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

   @Version
   @TableField(fill = FieldFill.INSERT)
   private  Integer version;//版本号

   @TableLogic
    private  Integer deleted;
}
