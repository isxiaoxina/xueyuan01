package com.cxxx.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package ：com.cxxx.servicebase.exceptionhandler
 * @ClassName：GuliException
 * @date ：2021/9/1920:16
 * @Description：
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuliException extends RuntimeException{

    private  Integer code;//状态码
    private  String msg;//异常信息

}
