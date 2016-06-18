package com.yawei.dao;

import com.yawei.entity.Movie;
import com.yawei.util.DbHelper;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class MovieDao {

    //查找所有条数据
    public List<Movie> findAll(){
        String sql = "SELECT * FROM movie";
        return DbHelper.query(sql,new BeanListHandler<>(Movie.class));
    }
    //start起始行，num跨越多少行
    public List<Movie> findByPage(int start,int num){
        String sql = "SELECT * FROM movie limit ?,?";
        return DbHelper.query(sql,new BeanListHandler<>(Movie.class),start,num);
    }

    //总行数
    public Long count(){
        String sql = "SELECT count(*) FROM movie";
        return DbHelper.query(sql,new ScalarHandler<Long>());
    }
}
