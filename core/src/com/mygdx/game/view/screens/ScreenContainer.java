package com.mygdx.game.view.screens;

import com.mygdx.game.view.screens.Screen;

public class ScreenContainer {

	private static Screen current, last;
	
	public static void setScreen(Screen s) {
		if (current != null) {
			current.dispose();
		}
		last = current;
		current = s;
		current.create();
	}
	
	public static void goBack() {
		if (current != null) {
			current.dispose();
		}
		Screen temp = last;
		last = current;
		current = temp;
		current.resume();
	}
	
	public static Screen getCurrent() {
		return current;
	}
	
}