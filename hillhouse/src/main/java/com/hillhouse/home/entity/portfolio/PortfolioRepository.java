package com.hillhouse.home.entity.portfolio;

import org.springframework.stereotype.Repository;

import com.hillhouse.home.entity.LanguageModelRepository;

@Repository
public class PortfolioRepository extends LanguageModelRepository<Portfolio, String> {
}
