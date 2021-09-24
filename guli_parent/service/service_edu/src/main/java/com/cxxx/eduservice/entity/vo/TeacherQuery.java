package com.cxxx.eduservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package ：com.cxxx.eduservice.entity.vo
 * @ClassName：TeacherQuery
 * @date ：2021/9/1819:40
 * @Description：  封装前端提交过来的条件的类
 */
@Data
public class TeacherQuery {

    @ApiModelProperty(value = "教师名称,模糊查询")
    private String name;   //根据名称 写条件   下面的

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
