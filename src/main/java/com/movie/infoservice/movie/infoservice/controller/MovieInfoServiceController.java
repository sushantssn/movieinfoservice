package com.movie.infoservice.movie.infoservice.controller;

import com.movie.infoservice.movie.infoservice.pojo.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/movies")
public class MovieInfoServiceController {
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
return new Movie(movieId,"Transformers");
    }
}
