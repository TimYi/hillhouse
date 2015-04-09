package com.hillhouse.home.entity.story;

import org.springframework.stereotype.Repository;

import com.hillhouse.home.entity.LanguageModelRepository;

@Repository
public class StoryRepository extends LanguageModelRepository<Story, String> {

}
