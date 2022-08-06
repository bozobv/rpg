package com.mygdx.game.view.io;

import com.mygdx.game.view.camera.OrthoCamera;

public interface InputListener {


	boolean onMousePressed(OrthoCamera cam, float x, float y, int button);


	boolean onMouseClicked(float x, float y, int button);
	
}