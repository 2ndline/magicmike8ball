package com.secondline.magic.shared;

import java.util.Random;

public enum Quote {

	Alright("Alright, alright, alright", "alright.mp3");
	String text;
	String source;
	
	Quote(String t, String s){
		this.text= t;
		this.source = s;
	}
	public String getText(){
		return this.text;
	}
	
	public String getSource(){
		return this.source;
	}
	
	
	private static final Random RANDOM = new Random();
	public static Quote getRandomQuote(){
		return values()[(RANDOM.nextInt(values().length))];
	}
}
