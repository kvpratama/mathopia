package com.kevinpratama.mathopia;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.kevinpratama.mathopia.SceneManager.SceneType;

import org.andengine.engine.camera.Camera;

public class SplashScene extends BaseScene {

	private Sprite splash;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		splash = new Sprite(640, 400, resourcesManager.splash_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		};

//		splash.setScale(1.5f);
//		splash.setPosition(640, 400);
		attachChild(splash);
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key splash scene", (long) 0);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_SPLASH;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		splash.detachSelf();
		splash.dispose();
		this.detachSelf();
		this.dispose();
	}

}
