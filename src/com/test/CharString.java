package com.test;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;


public class CharString {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		charToString();
	}

	public static void charToString() {

		char ch = 'J';

		String string1 = Character.toString(ch);
		String string2 = String.valueOf(ch);

		logger.debug("character is : " + ch + ". String using String.valueOf(char c):  " + string2);

		logger.debug("character is : " + ch + ". String using Character.toString(char c):  " + string1);

	}

	public static void StringToCharacter() {

		String g = "line";
		char c = g.charAt(0); // returns 'l'
		char[] c_arr = g.toCharArray();
	}
}
