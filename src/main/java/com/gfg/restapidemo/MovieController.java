package com.gfg.restapidemo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private List<Movie> movieList;

    // post, get, patch, put, delete

    @PostMapping("/movie")
    void createMovie(@RequestBody Movie movie) {
        this.movieList.add(movie);
    }

    @GetMapping("/movie")
    Movie getMovie(@RequestParam("name") String name) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name))
                return movie;
        }
        System.out.println("Get Mapping");
        return null;
    }

    @PatchMapping("/movie")
    String patchMapping(@RequestParam("name") String name, @RequestBody Movie movie) {
        for (Movie movie1 : movieList) {
            if (movie1.getName().equals(name)) {
                movie1.setRating(movie.getRating());
                return "Rating got updated";
            }
        }
        return "No movie found";
    }

    @PutMapping("/movie")
    String putMapping(@RequestParam("name") String name, @RequestBody Movie movie) {
        for (Movie movie2 : movieList) {
            if (movie2.getName().equals(name)){
                movieList.remove(movie2);
                movieList.add(movie);
                return "Rating got updated";
            }
        }
        return "No movie found";
    }

    @DeleteMapping("/movie")
    void del(@RequestParam("name") String name) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name))
                movieList.remove(movie);
        }
    }

}
