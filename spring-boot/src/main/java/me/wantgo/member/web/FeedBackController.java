package me.wantgo.member.web;

import me.wantgo.common.entity.RawString;
import me.wantgo.common.entity.ReturnValue;
import me.wantgo.member.entity.FeedBack;
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
    FeedBack getFeedBack(){
        return new FeedBack(24,"张向兵");
    }

    @RequestMapping(value = "/1",produces = "application/json")
    String getName(){
        return "张向兵";
    }

}
