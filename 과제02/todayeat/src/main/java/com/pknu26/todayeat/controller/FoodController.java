package com.pknu26.todayeat.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu26.todayeat.dto.FoodDto;
import com.pknu26.todayeat.mapper.FoodMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FoodController {

    // Service 대신 Mapper를 바로 연결
    private final FoodMapper foodMapper;

    // 랜딩 페이지 -> 목록으로 이동
    @GetMapping("/")
    public String home() {
        return "redirect:food/list";
    }

    // 음식 목록 조회
    @GetMapping("/food/list")
    public String list(@RequestParam(defaultValue = "eatDate") String orderBy,
                     Model model) {
        // 1. 매퍼를 통해 정렬된 리스트 가져오기
        List<FoodDto> foods = foodMapper.selectAll(orderBy);

        // 2. 뷰(Thymeleaf)로 데이터를 전달
        model.addAttribute("foods", foods);
        model.addAttribute("currentOrder", orderBy);

        return "list"; // templates/food/list.html
    }

    // 음식 정보 등록 실행
    @PostMapping("/food/add")
    public String addFood(@ModelAttribute FoodDto foodDto) {
        foodMapper.insertFood(foodDto);
        return "redirect:list";
    }

}
