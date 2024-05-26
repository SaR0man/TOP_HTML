package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieResponse getAllByTitle(String title, int page, int size);
}
