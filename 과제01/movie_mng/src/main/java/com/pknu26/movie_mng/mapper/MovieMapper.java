package com.pknu26.movie_mng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pknu26.movie_mng.dto.Movie;

@Mapper
public interface MovieMapper {

    // 목록 조회
    List<Movie> findAll();

    // 상세 조회
    Movie findById(Long movieId);

    // 등록
    int insert(Movie movie);

    // 수정
    int update(Movie movie);

    // 삭제
    int delete(Long movieId);
}