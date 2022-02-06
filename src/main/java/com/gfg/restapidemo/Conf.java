package com.gfg.restapidemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Conf {
    @Bean
    List<Movie> movieList() {return new ArrayList<>();}
}
