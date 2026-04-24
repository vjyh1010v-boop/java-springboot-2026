package com.pknu26.movie_mng.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pknu26.movie_mng.dto.Movie;
import com.pknu26.movie_mng.mapper.MovieMapper;
import com.pknu26.movie_mng.validation.MovieForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieMapper movieMapper;

    // 목록 조회
    @Override
    public List<Movie> getMovieList() {
        return movieMapper.findAll();
    }

    // 상세 조회
    @Override
    public Movie getMovieById(Long movieId) {
        return movieMapper.findById(movieId);
    }

    // 등록
    @Override
    public int createMovie(MovieForm movieForm) {
        Movie movie = new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setOriginalTitle(movieForm.getOriginalTitle());
        movie.setDirector(movieForm.getDirector());
        movie.setActors(movieForm.getActors());
        movie.setGenre(movieForm.getGenre());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setRunningTime(movieForm.getRunningTime());
        movie.setRating(movieForm.getRating());
        movie.setDescription(movieForm.getDescription());
        return movieMapper.insert(movie);
    }

    // 수정
    @Override
    public int updateMovie(MovieForm movieForm) {
        Movie movie = new Movie();
        movie.setMovieId(movieForm.getMovieId());
        movie.setTitle(movieForm.getTitle());
        movie.setOriginalTitle(movieForm.getOriginalTitle());
        movie.setDirector(movieForm.getDirector());
        movie.setActors(movieForm.getActors());
        movie.setGenre(movieForm.getGenre());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setRunningTime(movieForm.getRunningTime());
        movie.setRating(movieForm.getRating());
        movie.setDescription(movieForm.getDescription());
        return movieMapper.update(movie);
    }

    // 삭제
    @Override
    public int deleteMovie(Long movieId) {
        return movieMapper.delete(movieId);
    }
}