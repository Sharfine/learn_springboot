package com.sharfine.springboot.service;

import com.sharfine.springboot.model.EsEntity;
import com.sharfine.springboot.model.User;
import com.sharfine.springboot.util.EsUtil;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EsService {

    @Autowired
    private EsUtil esUtil;

    public List<User> getAll() {
        return esUtil.search(EsUtil.INDEX_NAME, new SearchSourceBuilder(), User.class);
    }

    public User getByUserId(int userId) {
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(new TermQueryBuilder("id", userId));
        List<User> res = esUtil.search(EsUtil.INDEX_NAME, builder, User.class);
        if (res.size() > 0) {
            return res.get(0);
        } else {
            return null;
        }
    }

    public List<User> searchByKey(String key) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", key));
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.size(10).query(boolQueryBuilder);
        return esUtil.search(EsUtil.INDEX_NAME, builder, User.class);
    }
    public List<User> searchByKeyAge(Integer key) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("age", key));
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.size(10).query(boolQueryBuilder);
        return esUtil.search(EsUtil.INDEX_NAME, builder, User.class);
    }

    public IndexResponse putOne(User user) {
        EsEntity<User> entity = new EsEntity<>(user.getId() + "", user);
        return esUtil.insertOrUpdateOne(EsUtil.INDEX_NAME, entity);
    }

    public BulkResponse putBatch(List<User> users) {
        List<EsEntity> list = new ArrayList<>();
        users.forEach(item -> list.add(new EsEntity<>(item.getId() + "", item)));
        return esUtil.insertBatch(EsUtil.INDEX_NAME, list);
    }

    public BulkByScrollResponse deleteById(int id) {
        return esUtil.deleteByQuery(EsUtil.INDEX_NAME, new TermQueryBuilder("id", id));
    }

    public BulkResponse deleteBatch(List<Integer> list) {
        return esUtil.deleteBatch(EsUtil.INDEX_NAME, list);
    }


}
