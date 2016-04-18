package com.kevinpratama.mathopia;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.ScrollDetector;
import org.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.andengine.input.touch.detector.SurfaceScrollDetector;
import org.andengine.opengl.util.GLState;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.kevinpratama.mathopia.SceneManager.SceneType;

public class CreditScene extends BaseScene implements IOnMenuItemClickListener {

	private static ScrollDetector mScrollDetector;
	private static boolean manualScrolling;

	private Sprite creditsTextHolder;

	private MenuScene creditMenuScene;
	private final int MENU_BACK = 0;
	private final int MENU_RESET = 1;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
		createCreditMenuScene();
		initializeResource();
//		gTracker.sendView("Reward Scene");
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key credit scene", (long) 0);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

	private void createBackground() {
		attachChild(new Sprite(640, 400,
				resourcesManager.main_menu_background_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void createCreditMenuScene() {
		creditMenuScene = new MenuScene(camera);
		creditMenuScene.setPosition(0, 0);

		final IMenuItem backMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_BACK,
						resourcesManager.back_button_region, vbom), 1.2f, 1);
		final IMenuItem resetMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_RESET,
						resourcesManager.reset_region, vbom), 1.2f, 1);

		creditMenuScene.addMenuItem(backMenuItem);
		creditMenuScene.addMenuItem(resetMenuItem);

		creditMenuScene.buildAnimations();
		creditMenuScene.setBackgroundEnabled(false);

		backMenuItem.setPosition(150, 100);
		resetMenuItem.setPosition(150, 700);

		creditMenuScene.setOnMenuItemClickListener(this);

		setChildScene(creditMenuScene);
	}

	private void initializeResource() {
		creditsTextHolder = new CreditSceneTextHolder(camera.getWidth() / 2, 0,
				resourcesManager.transparent_region, vbom, resourcesManager);
		creditsTextHolder.setPosition(camera.getWidth() / 2,
				0 - creditsTextHolder.getHeight() / 2);

		// this.attachChild(creditsText);
		this.attachChild(creditsTextHolder);
		this.registerUpdateHandler(new IUpdateHandler() {

			@Override
			public void reset() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onUpdate(float pSecondsElapsed) {
				// TODO Auto-generated method stub
				if (manualScrolling == false) {
					if (creditsTextHolder.getHeight() / 2
							+ creditsTextHolder.getY() < 0
							|| creditsTextHolder.getY() / 5.1 > camera
									.getHeight()) {
						creditsTextHolder.setPosition(camera.getWidth() / 2,
								0 - creditsTextHolder.getHeight() / 2);
					} else {
						creditsTextHolder.setPosition(
								creditsTextHolder.getX(),
								creditsTextHolder.getY()
										+ (float) getDropDistance(7,
												pSecondsElapsed));
					}
				}
			}
		});

		this.setOnSceneTouchListener(new IOnSceneTouchListener() {

			@Override
			public boolean onSceneTouchEvent(Scene pScene,
					TouchEvent pSceneTouchEvent) {
				// TODO Auto-generated method stub
				if (pSceneTouchEvent.isActionUp()) {
					manualScrolling = false;
					return true;
				} else {
					manualScrolling = true;
					mScrollDetector.onTouchEvent(pSceneTouchEvent);
					return true;
				}
			}
		});

		mScrollDetector = new SurfaceScrollDetector(
				new IScrollDetectorListener() {

					@Override
					public void onScrollStarted(ScrollDetector pScollDetector,
							int pPointerID, float pDistanceX, float pDistanceY) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onScroll(ScrollDetector pScollDetector,
							int pPointerID, float pDistanceX, float pDistanceY) {
						// TODO Auto-generated method stub

						if (creditsTextHolder.getHeight() / 2
								+ creditsTextHolder.getY() < 0
								|| creditsTextHolder.getY() / 5.1 > camera
										.getHeight()) {
							creditsTextHolder.setPosition(
									camera.getWidth() / 2,
									0 - creditsTextHolder.getHeight() / 2);
						}

						else {
							creditsTextHolder.setPosition(
									creditsTextHolder.getX(),
									creditsTextHolder.getY() - pDistanceY);
						}
					}

					@Override
					public void onScrollFinished(ScrollDetector pScollDetector,
							int pPointerID, float pDistanceX, float pDistanceY) {
						// TODO Auto-generated method stub

					}

				});

		mScrollDetector.setEnabled(true);

		this.setOnSceneTouchListener(this.getOnSceneTouchListener());
		this.setOnSceneTouchListenerBindingEnabled(true);

	}

	private void setOnSceneTouchListenerBindingEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

	public double getDropDistance(double dropRate, float mSecondsElapsed) {
		/*
		 * dropRate is how fast in seconds it should take the mexican to travel
		 * the distance of the screen
		 */

		return (camera.getHeight() * mSecondsElapsed) / dropRate;
	}

	private void confirmReset() {
		final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
		alert.setIcon(android.R.drawable.ic_dialog_alert);
		alert.setTitle("Reset");
		alert.setMessage("Reset all Mathopia data ?");
		alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				if (databaseHandler.resetApplicationData()) {
					SceneManager.getInstance().onResetApplicationData();
				}
				// System.exit(1);
			}
		});
		alert.setNegativeButton("No", null);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				alert.show();
			}
		});
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		resourcesManager.buttonSound.play();
		switch (pMenuItem.getID()) {
		case MENU_BACK:
			gTracker.sendEvent("back button", "user clicked back button", "back button credit scene", (long) 0);
			SceneManager.getInstance().setMenuScene();
			creditsTextHolder.setPosition(camera.getWidth() / 2,
					0 - creditsTextHolder.getHeight() / 2);
			return true;
		case MENU_RESET:
			gTracker.sendEvent("reset button", "user clicked reset button", "reset button credit scene", (long) 0);
			confirmReset();
			return true;
		default:
			return false;
		}
	}
}
