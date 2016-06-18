package com.yawei.service;

import com.yawei.dao.MovieDao;
import com.yawei.entity.Movie;
import com.yawei.util.Page;

import java.util.List;

public class MovieService {
    private MovieDao movieDao = new MovieDao();


    //查找所有电影
    public List<Movie> findAllMovie() {
        return movieDao.findAll();
    }

    //通过当前页码查找电影
    public Page<Movie> findMovieByCurrentPage(int currentPage) {//传入当前页参数
        int movieTotal = movieDao.count().intValue();
        Page<Movie> page = new Page<>(currentPage, 10, movieTotal);
        List<Movie> movieList = movieDao.findByPage(page.getStart(), 10);
        page.setItems(movieList);
        return page;
        /*int movieTotal = movieDao.count().intValue();//数据库中的总记录数
        int num = 10;
        int pageTotal = movieTotal / num;//可以分成的总页数
        if (movieTotal % num != 0) {
            pageTotal++;
        }

        //判断当前页与总页数的大小
        if (currentPage>pageTotal){
            currentPage=pageTotal;//如果当前页数大于总页数，将总页数赋值给当前页
        }

        int start = (currentPage-1)*num;//当前页所要显示的起始记录的位置
        return movieDao.findByPage(start,num);*/
    }
}
