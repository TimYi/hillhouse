package com.hillhouse.home.entity.news;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="NEWS")
public class News extends AbstractNews {
}
