package com.hillhouse.home.entity.news;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PORTFOLIO")
public class PortfolioNews extends AbstractNews {

}
