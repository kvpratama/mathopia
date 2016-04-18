package com.kevinpratama.mathopia;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.kevinpratama.mathopia.SceneManager.SceneType;

public class LoadingScene extends BaseScene {

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		
		AnimatedSprite turtle_run = new AnimatedSprite(650, 230,
				resourcesManager.turtle_run_region, vbom);
		final long[] turtleAnimate = new long[] { 250, 175 };
		turtle_run.animate(turtleAnimate);
		
		Sprite loading = new Sprite(1000, 150, resourcesManager.loading_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		};
		attachChild(turtle_run);
		attachChild(loading);
		
//		setBackground(new Background(Color.WHITE));
//		Rectangle rectangle1 = new Rectangle(100, 200, 50, 50,
//				resourcesManager.vbom);
//		Rectangle rectangle2 = new Rectangle(210, 200, 50, 50,
//				resourcesManager.vbom);
//		Rectangle rectangle3 = new Rectangle(320, 200, 50, 50,
//				resourcesManager.vbom);
//		rectangle1.setColor(Color.BLUE);
//		rectangle2.setColor(Color.BLACK);
//		rectangle3.setColor(Color.GREEN);

//		rectangle1
//				.registerEntityModifier(new LoopEntityModifier(
//						new ScaleModifier(1, 1, 1, 1, 1.5f, EaseBounceOut
//								.getInstance())));
//		rectangle2.registerEntityModifier(new LoopEntityModifier(
//				new ScaleModifier(1, 1, 1, 1, 2, EaseBounceOut.getInstance())));
//		rectangle3.registerEntityModifier(new LoopEntityModifier(
//				new ScaleModifier(1, 1, 1, 1, 2.5f, EaseBounceInOut
//						.getInstance())));
//		rectangle3.registerEntityModifier(new LoopEntityModifier(
//				new MoveModifier(1, 320, 400, 320, 200, EaseBounceOut
//						.getInstance())));

		// rectangle.registerEntityModifier(new LoopEntityModifier(new
		// MoveModifier(2,
		// 100, 200, 200, 200, EaseBounceOut.getInstance())));
//		attachChild(new Text(640, 400, resourcesManager.font, "Loading...",
//				vbom));

//		attachChild(rectangle1);
//		attachChild(rectangle2);
//		attachChild(rectangle3);
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key loading scene", (long) 0);		
		return;
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_LOADING;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

}
