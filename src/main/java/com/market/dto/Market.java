package com.market.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Market {
	private int num;
	private String name;
	private String img;
	private String content;
	private String category;
	private int price;
	private int hitCount;
	private int good;
}
