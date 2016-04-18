package com.kevinpratama.mathopia;

import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.util.modifier.ease.EaseBounceOut;
import org.andengine.engine.camera.Camera;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.kevinpratama.mathopia.SceneManager.SceneType;

public class MainMenuScene extends BaseScene implements
		IOnMenuItemClickListener {

	private MenuScene menuChildScene;
	private final int MENU_PLAY = 0;
	private final int MENU_CREDIT = 1;

	// private Sound buttonSound;

	// private final int MENU_OPTIONS = 1;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createSound();
		createBackground();
		createTexture();
		createMenuChildScene();
		gTracker.sendView("Main Menu Scene");
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alert = new AlertDialog.Builder(activity);
		alert.setIcon(android.R.drawable.ic_dialog_alert);
		alert.setTitle("Exit");
		alert.setMessage("Exit from Mathopia ?");
		alert.setPositiveButton("Exit", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		alert.setNegativeButton("Cancel", null);
		alert.show();
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key main menu scene", (long) 0);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_MENU;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

	private void createSound() {
		// Music backsound = resourcesManager.backSound;
		// backsound.setLooping(true);

		// buttonSound = resourcesManager.buttonSound;
		resourcesManager.backSound.play();
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

	private void createTexture() {
		Sprite cloud = new Sprite(1280, 700, resourcesManager.cloud_region,
				vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		};
		cloud.registerEntityModifier(new LoopEntityModifier(new MoveXModifier(
				40, 1480, -200)));

		Sprite cloud2 = new Sprite(-200, 600, resourcesManager.cloud_region2,
				vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		};
		cloud2.registerEntityModifier(new LoopEntityModifier(new MoveXModifier(
				30, -200, 1480)));

		Sprite mathopia = new Sprite(640, 500,
				resourcesManager.mathopia_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		};

		mathopia.registerEntityModifier(new MoveModifier(3f, 640, 1000, 640,
				500, EaseBounceOut.getInstance()));

		attachChild(cloud);
		attachChild(cloud2);
		attachChild(mathopia);
	}

	private void createMenuChildScene() {
		menuChildScene = new MenuScene(camera);
		menuChildScene.setPosition(0, 0);

		final IMenuItem playMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PLAY, resourcesManager.play_region,
						vbom), 1.2f, 1);
		final IMenuItem creditMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_CREDIT,
						resourcesManager.credit_button_region, vbom), 1.2f, 1);

		menuChildScene.addMenuItem(playMenuItem);
		menuChildScene.addMenuItem(creditMenuItem);
		// menuChildScene.addMenuItem(optionsMenuItem);

		menuChildScene.buildAnimations();
		menuChildScene.setBackgroundEnabled(false);

		// playMenuItem.setPosition(playMenuItem.getX(), playMenuItem.getY() +
		// 10);
		// optionsMenuItem.setPosition(optionsMenuItem.getX(),
		// optionsMenuItem.getY() - 110);
		playMenuItem.setPosition(camera.getWidth() / 2, 200);
		creditMenuItem.setPosition(1150, 150);
		// optionsMenuItem.setPosition(0,
		// playMenuItem.getY() - playMenuItem.getHeight() - 5);

		menuChildScene.setOnMenuItemClickListener(this);

		setChildScene(menuChildScene);
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		resourcesManager.buttonSound.play();
		switch (pMenuItem.getID()) {
		case MENU_PLAY:
			// Load Game Scene!
			gTracker.sendEvent("play button", "user clicked play button", "play button main menu scene", (long) 0);
			SceneManager.getInstance().setStageMenuScene();
			return true;
		case MENU_CREDIT:
			gTracker.sendEvent("credit button", "user clicked credit button", "credit button main menu scene", (long) 0);
			SceneManager.getInstance().setCreditScene();
			return true;
		default:
			return false;
		}
	}

}
