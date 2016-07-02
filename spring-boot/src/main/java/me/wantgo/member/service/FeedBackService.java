package me.wantgo.member.service;

import me.wantgo.member.entity.FeedBack;

/**
 * Created by zxb on 7/2/16.
 */
public interface FeedBackService {

    FeedBack getFeedBackById(int Id);

    boolean addFeedBack(FeedBack feedBack);
}
