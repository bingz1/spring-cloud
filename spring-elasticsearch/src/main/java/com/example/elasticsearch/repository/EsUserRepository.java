package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author xiangbing.zhang@wework.cn
 * @Description
 * @Date 2022/2/8
 **/
public interface EsUserRepository extends ElasticsearchRepository<User,Integer> {

    //根据name查询
    List<User> findByName(String name);


    @Highlight(fields = {
            @HighlightField(name = "name"),
            @HighlightField(name = "info")
    })
    List<SearchHit<User>> findByNameOrInfo(String name, String info);

}
