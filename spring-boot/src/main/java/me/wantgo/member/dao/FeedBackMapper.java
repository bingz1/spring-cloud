package me.wantgo.member.dao;

import me.wantgo.member.entity.FeedBack;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

public interface FeedBackMapper {

    int deleteByPrimaryKey(Integer id);

    @Insert("insert into feedbacks(name,age,content) values (#{name},#{age},#{content})")
    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    @Select("select * from feedbacks where id = #{id}")
    FeedBack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);
}