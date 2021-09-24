package com.cxxx.mpdemo10;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxxx.mpdemo10.entity.User;
import com.cxxx.mpdemo10.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Mpdemo10ApplicationTests {

    @Autowired
    UserMapper userMapper;


    @Test
    void contextLoads() {

        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

    @Test
    void addUser(){
        User user = new User();
        user.setName("广志");
        user.setAge(35);
        user.setEmail("guangzhi@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);

    }


    @Test
    public void update(){

        User user = new User();
        user.setId(0l);
        user.setAge(100);
        int i = userMapper.updateById(user);
        System.out.println(i);


    }
    @Test
    public  void testoptimisticLockerInterceptor(){

        User user = userMapper.selectById(1438798853175316482l);
        user.setAge(5);
        int i = userMapper.updateById(user);

    }
    @Test
    public  void testSelectDemo(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1l, 2l, 3l));
        System.out.println(users);


    }

    @Test
    //常用  分页查询
    public  void testpage(){
        //1创建page对象
        //传入两个参数 当前页  和每页显示的记录数
        Page<User> page = new Page<>(1,2);
       //调用mp分页查询的方法
        userMapper.selectPage(page,null);
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//总页数
    }


    //逻辑删除   deleted变成1就是删除
    @Test
    public  void testdelete(){
        int i = userMapper.deleteById(1438812824519380994L);
    }

    @Test  //条件查询
    public  void  testselectquery(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //ge， gt，le，lt
    //age>=30    eq、ne  等于不等于
       // wrapper.eq("name","广志");
        //wrapper.select("id","name");
        wrapper.orderByDesc("name");
        List<User> users = userMapper.selectList(wrapper);

        System.out.println(users);
        
    
    

    //
}


public  void delete(){
    int i = userMapper.deleteById(1);

}
}
