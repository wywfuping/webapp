package com.yawei.service;

import com.yawei.entity.Movie;
import com.yawei.util.Page;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MovieServiceTestCase {
    private Logger logger = LoggerFactory.getLogger(MovieServiceTestCase.class);
    private MovieService movieService = new MovieService();

    @Test
    public void testFindAll() {
        List<Movie> movieList = movieService.findAllMovie();
        assertNotNull(movieList);
    }

    @Test
    public void testFindByPage(){
        Page<Movie> page=movieService.findMovieByCurrentPage(2);
        for (Movie movie:page.getItems()){
            logger.debug("{}",movie);
        }
        assertEquals(10,page.getItems().size());
    }
}
