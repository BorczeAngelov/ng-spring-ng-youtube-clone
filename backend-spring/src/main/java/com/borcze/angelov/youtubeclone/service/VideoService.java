package com.borcze.angelov.youtubeclone.service;

import com.borcze.angelov.youtubeclone.dto.VideoDto;
import com.borcze.angelov.youtubeclone.model.Video;
import com.borcze.angelov.youtubeclone.repository.VideoRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoService {

    private final S3Service s3Service;
    private final VideoRepository videoRepository;

    public VideoService(S3Service s3Service, VideoRepository videoRepository) {
        this.s3Service = s3Service;
        this.videoRepository = videoRepository;
    }

    public void uploadVideo(MultipartFile file) {
        var videoUrl = s3Service.uploadFile(file);

        var video = new Video();
        video.setUrl(videoUrl);

        videoRepository.save(video);
    }

    public VideoDto editVideo(VideoDto videoDto) {

        var savedVideo = videoRepository.findById(videoDto.getVideoId())
                .orElseThrow(() -> new IllegalArgumentException("Cannot find video by id - " + videoDto.getVideoId()));

        // Map the video Dto fileds to video
        savedVideo.setTitle(videoDto.getVideoName());
        savedVideo.setDescription(videoDto.getDescription());
        savedVideo.setUrl(videoDto.getUrl());
        savedVideo.setTags(videoDto.getTags());
        savedVideo.setVideoStatus(videoDto.getVideoStatus());

        videoRepository.save(savedVideo);
        return videoDto;
    }
}
