package com.borcze.angelov.youtubeclone.repository;

import com.borcze.angelov.youtubeclone.model.Video;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {

}
