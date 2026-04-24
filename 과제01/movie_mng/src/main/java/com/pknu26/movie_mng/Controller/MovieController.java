package com.pknu26.movie_mng.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.movie_mng.dto.Movie;
import com.pknu26.movie_mng.Service.MovieService;
import com.pknu26.movie_mng.validation.MovieForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // [추가된 부분] /movie 로 접속 시 자동으로 목록 페이지로 리다이렉트
    @GetMapping({"", "/"})
    public String defaultLocation() {
        return "redirect:/movie/list";
    }

    // 목록 조회
    @GetMapping("/list")
    public String list(Model model) {
        List<Movie> movieList = movieService.getMovieList();
        model.addAttribute("movieList", movieList);
        return "movie/list"; // 맨 앞의 "/" 제거하여 경로 안정성 확보
    }

    // 상세 조회
    @GetMapping("/detail/{movieId}")
    public String detail(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movie/detail"; // 맨 앞의 "/" 제거
    }

    // 등록 화면
    @GetMapping("/create")
    public String showCreateForm(@ModelAttribute("movieForm") MovieForm movieForm) {
        return "movie/form"; // movie 폴더 안의 form.html을 찾도록 경로 지정
    }

    // 등록 처리
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("movieForm") MovieForm movieForm,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "movie/form"; 
        }
        movieService.createMovie(movieForm);
        return "redirect:/movie/list";
    }

    // 수정 화면
    @GetMapping("/edit/{movieId}")
    public String showEditForm(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);

        MovieForm movieForm = new MovieForm();
        movieForm.setMovieId(movie.getMovieId());
        movieForm.setTitle(movie.getTitle());
        movieForm.setOriginalTitle(movie.getOriginalTitle());
        movieForm.setDirector(movie.getDirector());
        movieForm.setActors(movie.getActors());
        movieForm.setGenre(movie.getGenre());
        movieForm.setReleaseDate(movie.getReleaseDate());
        movieForm.setRunningTime(movie.getRunningTime());
        movieForm.setRating(movie.getRating());
        movieForm.setDescription(movie.getDescription());

        model.addAttribute("movieForm", movieForm);
        return "movie/form";
    }

    // 수정 처리
    @PostMapping("/edit/{movieId}")
    public String edit(@PathVariable("movieId") Long movieId,
                       @Valid @ModelAttribute("movieForm") MovieForm movieForm,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "movie/form";
        }
        movieForm.setMovieId(movieId);
        movieService.updateMovie(movieForm);
        return "redirect:/movie/detail/" + movieId;
    }

    // 삭제 처리
    @PostMapping("/delete/{movieId}")
    public String delete(@PathVariable("movieId") Long movieId) {
        movieService.deleteMovie(movieId);
        return "redirect:/movie/list";
    }
}