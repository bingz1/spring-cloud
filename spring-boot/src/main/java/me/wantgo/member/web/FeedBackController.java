package me.wantgo.member.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zxb on 7/1/16.
 * 意见反馈相关服务.
 */
@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @RequestMapping
    String getFeedBack(){
        return "返回意见反馈相关信息";
    }

}
