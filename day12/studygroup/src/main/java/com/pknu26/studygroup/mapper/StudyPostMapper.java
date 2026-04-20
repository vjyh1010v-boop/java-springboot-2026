package com.pknu26.studygroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pknu26.studygroup.dto.StudyPost;

@Mapper
// CRUD 중에서 Creat, Read만 존재
public interface StudyPostMapper {
      List<StudyPost> findAll();

    StudyPost findById(Long postId);

    void insertPost(StudyPost studyPost);

    void deletePost(Long postId);

    void updatePost(StudyPost studyPost);

    void increaseViewCount(Long postId); // 조회수 증가


}
