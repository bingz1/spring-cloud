package me.wantgo.member.web;

import me.wantgo.common.entity.RawString;
import me.wantgo.common.entity.ReturnValue;
import me.wantgo.member.entity.FeedBack;
import me.wantgo.member.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zxb on 7/1/16.
 * 意见反馈相关服务.
 */
@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping("/{id}")
    FeedBack getFeedBack(@PathVariable int id){
        return feedBackService.getFeedBackById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    boolean setFeedBack(@RequestBody FeedBack feedBack){
        return feedBackService.addFeedBack(feedBack);
    }

}
