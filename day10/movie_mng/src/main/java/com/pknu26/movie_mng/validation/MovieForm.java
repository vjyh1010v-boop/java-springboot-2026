package com.pknu26.movie_mng.validation;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieForm {

    private Long movieId; // 수정할 때 필요

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    private String originalTitle;

    private String director;

    private String actors;

    private String genre;

    @NotNull(message = "개봉일을 입력해주세요.")
    private LocalDate releaseDate;

    @Min(value = 1, message = "상영시간은 1분 이상이어야 합니다.")
    private int runningTime;

    @DecimalMin(value = "0.0", message = "평점은 0.0 이상이어야 합니다.")
    @DecimalMax(value = "10.0", message = "평점은 10.0 이하이어야 합니다.")
    private double rating;

    private String description;
}