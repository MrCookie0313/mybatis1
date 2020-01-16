package com.cookie.mybatis.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
@Api(value = "视频相关业务的接口",tags = {"视频相关业务的controller"})
public class VideoController {
}