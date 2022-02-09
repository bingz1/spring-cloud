package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.User;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EsUserRepositoryTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private EsUserRepository esUserRepository;

    private String[] names={"诸葛亮","曹操","李白","韩信","赵云","小乔","狄仁杰","李四","诸小明","王五"};
    private String[] infos={"我来自中国的一个小乡村，地处湖南省","我来自中国的一个大城市，名叫上海，人们称作魔都"
            ,"我来自东北，家住大囤里，一口大碴子话"};

    @PostConstruct
    void init() {
        elasticsearchRestTemplate.indexOps(User.class);
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i=0;i<20;i++){
            User user = new User();
            user.setId(i);
            user.setName(names[random.nextInt(9)]);
            user.setAge(random.nextInt(40)+i);
            user.setInfo(infos[random.nextInt(2)]);
            users.add(user);
        }
        esUserRepository.saveAll(users);
    }

    @Test
    void findById() {
        User user = esUserRepository.findById(1).get();
        Assertions.assertNotNull(user);
    }

    @Test
    void getAllDataByPage() {
        //本该传入page和size，这里为了方便就直接写死了
        Pageable page = PageRequest.of(0, 10, Sort.Direction.ASC, "id");
        Page<User> all = esUserRepository.findAll(page);
        Assertions.assertNotNull(all);
    }

    @Test
    void findByName() {
        List<User> users = esUserRepository.findByName("诸");
        Assertions.assertNotNull(users);
    }

    @Test
    void getHighlightByUser() {
        String value = "上海";
        //根据一个值查询多个字段  并高亮显示  这里的查询是取并集，即多个字段只需要有一个字段满足即可
        //需要查询的字段
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("info",value))
                .should(QueryBuilders.matchQuery("name",value));
        //构建高亮查询
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withHighlightFields(
                        new HighlightBuilder.Field("info")
                        ,new HighlightBuilder.Field("name"))
                .withHighlightBuilder(new HighlightBuilder().preTags("<span style='color:red'>").postTags("</span>"))
                .build();
        //查询
        SearchHits<User> search = elasticsearchRestTemplate.search(searchQuery, User.class);
        //得到查询返回的内容
        List<SearchHit<User>> searchHits = search.getSearchHits();
        //设置一个最后需要返回的实体类集合
        List<User> users = new ArrayList<>();
        //遍历返回的内容进行处理
        for(SearchHit<User> searchHit:searchHits){
            //高亮的内容
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
            //将高亮的内容填充到content中
            searchHit.getContent().setName(highlightFields.get("name")==null ? searchHit.getContent().getName():highlightFields.get("name").get(0));
            searchHit.getContent().setInfo(highlightFields.get("info")==null ? searchHit.getContent().getInfo():highlightFields.get("info").get(0));
            //放到实体类中
            users.add(searchHit.getContent());
        }
        Assertions.assertNotNull(users);
    }

    @Test
    void findByNameOrInfo() {
        List<SearchHit<User>> users = esUserRepository.findByNameOrInfo("诸葛亮","上海");
        Assertions.assertNotNull(users);
    }
}