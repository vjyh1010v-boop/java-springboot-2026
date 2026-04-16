package com.pknu26.movie_mng.Service;

import java.util.List;

import com.pknu26.movie_mng.dto.Movie;
import com.pknu26.movie_mng.validation.MovieForm;

public interface MovieService {

    // 목록 조회
    List<Movie> getMovieList();

    // 상세 조회
    Movie getMovieById(Long movieId);

    // 등록
    int createMovie(MovieForm movieForm);

    // 수정
    int updateMovie(MovieForm movieForm);

    // 삭제
    int deleteMovie(Long movieId);
}