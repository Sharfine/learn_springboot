package com.sharfine.springboot.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("com.sharfine.springboot.action.data.elasticsearch")
public class ElasticSearchConfig {

}
