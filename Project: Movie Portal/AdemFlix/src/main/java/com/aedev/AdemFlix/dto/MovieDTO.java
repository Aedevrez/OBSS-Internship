package com.aedev.AdemFlix.dto;

import java.util.List;

import com.aedev.AdemFlix.entity.Director;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private String genre;
    private List<Director> directors;
    private String summary;
}
