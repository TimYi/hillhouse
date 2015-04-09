package com.hillhouse.home.entity.news;

import org.springframework.stereotype.Repository;

import com.hillhouse.home.entity.LanguageModelRepository;

@Repository
public class NewsRepository extends LanguageModelRepository<News, String> {

}
