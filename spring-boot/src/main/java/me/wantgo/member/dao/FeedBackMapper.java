package me.wantgo.member..dao;

import me.wantgo.member.entity.FeedBack;

public interface FeedBackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    FeedBack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);
}