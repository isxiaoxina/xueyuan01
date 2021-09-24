package com.cxxx.eduservice.controller;





import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxxx.commonutils.R;
import com.cxxx.eduservice.entity.EduTeacher;
import com.cxxx.eduservice.entity.vo.TeacherQuery;
import com.cxxx.eduservice.service.EduTeacherService;
import com.cxxx.servicebase.exceptionhandler.GuliException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-09-18
 */
@Api(tags="讲师管理")
@RestController  //组件   然后输出转换成json
@RequestMapping("/eduservice/edu-teacher")   //下面所有方法的模块名前缀
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    //1查询讲师表所有数据  rest风格
    @GetMapping("findAll")
    @ApiOperation(value = "所有讲师列表")
    public R findAllTeach(){

        List<EduTeacher> list = teacherService.list(null);
        return  R.ok().data("items",list);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据ID删除讲师")
    public R Edudelete(@ApiParam(name = "id", value = "讲师ID", required = true)

            @PathVariable String id){//获取路径中的数据
        boolean b = teacherService.removeById(id);
        if (false){
            return R.ok();
        }else {
            return R.error();
        }

    }

    //3  分页查询
    @GetMapping("pageteacher/{current}/{limit}")
    @ApiOperation(value = "分页查询")
    public  R page(
                       @PathVariable long current,
                           @PathVariable long limit){


        Page<EduTeacher> page = new Page<>(current,limit);

        //调用page方法  把分页所有 的数据封装到page里面
        teacherService.page(page,null );
         int i ;

         try {
             i=10/0;
         }catch (Exception e){
        throw new GuliException(20001,"执行了我自定义的异常处理");
         }



        long total = page.getTotal();//总记录输
        List<EduTeacher> records = page.getRecords();//  数据集合

     /*   Map map = new HashMap<>();
        map.put("total",total);
        map.put("rows",records);
        return  R.ok().data(map);*/

        return  R.ok().data("total",total).data("rows",records);




    }

    //条件查询 带分页
    @PostMapping ("pageTeacherCondition/{current}/{limit}")
    @ApiOperation(value = "条件分页查询")
    public  R  pageTeacherCondition(@PathVariable long current,
                                    @PathVariable long  limit,
                                     @RequestBody(required = false) TeacherQuery teacherQuery){//用这个对象做条件值
                                   //@RequestBody(required = false)  表示这个值可以没有
        //创建一个page对象
        Page<EduTeacher> page = new Page<>(current,limit);
        //创建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name", name);  //字段名 和实际值
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level", level);  //字段名 和实际值
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create", begin);  //字段名 和实际值
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create", end);  //字段名 和实际值
        }


        teacherService.page(page, wrapper);

        long total = page.getTotal();
        List<EduTeacher> records = page.getRecords();   //records记录
        return  R.ok().data("total",total).data("rows",records);





    }


    //添加讲师接口的方法
    @PostMapping("addTeacher")
    public  R addTeacher(@RequestBody EduTeacher teacher){
        boolean save = teacherService.save(teacher);
        if (save){
            return R.ok();

        }else {
            return R.error();
        }

    }
    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    public  R getTeahcer(@PathVariable String id){
        EduTeacher byId = teacherService.getById(id);
        return R.ok().data("teacher",byId);

    }


     @PostMapping("updateTeacher")   //增  postMapping
    public  R updateTeacher(@RequestBody EduTeacher teacher){

         boolean b = teacherService.updateById(teacher);
         if (b){
             return R.ok();
         }else {
             return R.error();
         }


     }


}

