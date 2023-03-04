package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll() {
        List<MovieDTO> movieDTOS = movieService.findAll();
        return ResponseEntity.ok().body(movieDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        MovieDTO movieDTO = movieService.findById(id);
        return ResponseEntity.ok().body(movieDTO);
    }

    @GetMapping("/{idMovie}/reviews")
    public ResponseEntity<List<ReviewDTO>> findReviewsFromMovieId(@PathVariable Long idMovie) {
        List<ReviewDTO> reviews = movieService.findReviewsFromMovieId(idMovie);
        return ResponseEntity.ok().body(reviews);
    }
}
