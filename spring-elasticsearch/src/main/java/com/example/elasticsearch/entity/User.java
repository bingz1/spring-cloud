package com.example.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author xiangbing.zhang@wework.cn
 * @Description
 * @Date 2022/2/8
 **/
@Data
@Document(indexName = "user")//索引名称 建议与实体类一致
public class User {
    @Id
    private Integer id;
    @Field(type = FieldType.Auto)//自动检测类型
    private Integer age;
    @Field(type = FieldType.Keyword)//手动设置为keyword  但同时也就不能分词
    private String name;
    @Field(type = FieldType.Text)
    private String info;
}
