package com.cookie.mybatis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunbing
 * @date 2020/1/7 17:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@Api(tags = "出差接口")
public class FirstWebController {

    @ApiOperation("出差提交接口")
    @PostMapping("/add")
    public void test(){
        int z =1/2;
    }
}
