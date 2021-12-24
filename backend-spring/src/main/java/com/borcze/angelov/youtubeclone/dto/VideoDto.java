package com.borcze.angelov.youtubeclone.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.borcze.angelov.youtubeclone.model.VideoStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {

    private String videoId;
    @NotBlank
    private String userId;
    @NotBlank
    private String videoName;
    @NotBlank
    private String description;
    @Size(min = 1)
    private List<String> tags;
    private VideoStatus videoStatus;
    @NotBlank
    private String url;
    @NotBlank
    private String thumbnailUrl;
    @Min(value = 0)
    private int likeCount;
    @Min(value = 0)
    private int dislikeCount;
}
