package com.cxxx.servicebase.exceptionhandler;




import com.cxxx.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package ：com.cxxx.servicebase.exceptionhandler
 * @ClassName：exhandler
 * @date ：2021/9/190:37
 * @Description：
 */
@Slf4j
@ControllerAdvice//  控制参考说明   定义异常类添加到组件里面
public class exhandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody  //为了返回响应的数据  用json形式输出在前端页面
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("全局都是这个异常");
    }

    //特定异常  算术异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return  R.error().message("Arithmetic特定异常");
    }
    //自定义异常
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return  R.error().code(e.getCode()).message(e.getMsg());
    }

}
