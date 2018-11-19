package me.wantgo.member.service.impl;

import me.wantgo.member.dao.FeedBackMapper;
import me.wantgo.member.entity.FeedBack;
import me.wantgo.member.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxb on 7/2/16.
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackMapper feedBackMapper;

    @Override
    public FeedBack getFeedBackById(int Id) {
        return feedBackMapper.selectByPrimaryKey(Id);
    }

    @Override
    public boolean addFeedBack(FeedBack feedBack) {
        int count = feedBackMapper.insert(feedBack);
        return count != 0;
    }
}
