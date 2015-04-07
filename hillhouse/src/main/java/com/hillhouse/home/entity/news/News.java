package com.hillhouse.home.entity.news;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value="NEWS")
public class News extends AbstractNews {
}
