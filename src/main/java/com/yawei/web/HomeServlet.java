package com.yawei.web;


import com.yawei.entity.Movie;
import com.yawei.service.MovieService;
import com.yawei.util.Page;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countPage=req.getParameter("p");
        int p = 1;
        if (StringUtils.isNumeric(countPage)){
            p = Integer.parseInt(countPage);
        }

        MovieService movieService = new MovieService();
        Page<Movie> page = movieService.findMovieByCurrentPage(p);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}
