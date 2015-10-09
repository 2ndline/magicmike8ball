package com.secondline.magic.shared;

import java.util.Random;

public enum Quote {

	Alright("Alright, alright, alright", "alright.mp3"),
	HighSchool("I love high school girls...", "highschool.mp3"),
	SuckThis("Suck this", "suckthis.mp3"),
	CutYourFace("I will cut your face off...", "cutyourface.mp3"),
	DoYouWant("Do you want me?", "doyouwant.mp3"),
	StayRelaxed("You gotta stay relaxed", "stayrelaxed.mp3"),
	TwiceADay("I jerk off at least twice a day", "twiceaday.mp3"),
	FeedTheGeese("You gotta feed the geese...", "feedthegeese.mp3"),
	Decent("That person's a piece of shit", "decent.mp3"),
	BeenThatWay("Been that way...", "beenthatway.mp3"),
	Livin("You just gotta keep livin", "livin.mp3");
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
