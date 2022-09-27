package com.movie.infoservice.movie.infoservice.controller;

import com.movie.infoservice.movie.infoservice.pojo.Movie;
import com.movie.infoservice.movie.infoservice.pojo.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieInfoServiceController {

    @Autowired
    WebClient.Builder webClientBuilder ;
    @Autowired
    RestTemplate restTemplate ;
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
RestTemplate restTemplate1 = new RestTemplate();
        MovieSummary movieSummaryMono = restTemplate1.getForObject("https://api.themoviedb.org/3/movie/25?api_key=5f4a971aefefa3bbbfdb9bd2baff3add", MovieSummary.class);
     /* MovieSummary movieSummaryMono = webClientBuilder.build()
                .get()
                .uri("https://api.themoviedb.org/3/movie/"+movieId+"?api_key=5f4a971aefefa3bbbfdb9bd2baff3add")
                .retrieve()
                .bodyToMono(MovieSummary.class)
                .block();
*/
        System.out.println(movieSummaryMono.getId()+"  "+movieSummaryMono.getTitle()+"  "+movieSummaryMono.getOverview());
        //return movieSummaryMono;
return new Movie(movieId,movieSummaryMono.getTitle(), movieSummaryMono.getOverview());
    }
}
