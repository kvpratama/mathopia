package com.kevinpratama.mathopia.gamescene.garisbilangan;

import java.util.ArrayList;

import org.andengine.audio.music.Music;
import org.andengine.audio.sound.Sound;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.AnimatedSprite.IAnimationListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.util.GLState;

//import com.kevinpratama.matematika.LevelCompleteWindow.TurtleCount;
import com.kevinpratama.mathopia.BaseScene;
import com.kevinpratama.mathopia.GameManager;
import com.kevinpratama.mathopia.LevelCompleteWindow;
import com.kevinpratama.mathopia.SceneManager;
import com.kevinpratama.mathopia.SwappableNumber;
import com.kevinpratama.mathopia.SceneManager.SceneType;
import com.kevinpratama.mathopia.datamanager.DatabaseHandler;
import com.kevinpratama.mathopia.datamanager.Reward;

public class GarisBilanganGameScene extends BaseScene {

	private Sprite[] choicesHolder, answerHolder;
	// private Number[] numberHolder;
	private SwappableNumber[] swappableNumberHolder;
	private AnimatedSprite[] turtle, completeTurtle, eagle;
	private Sprite false_sign, mystery_box, line;

	private int eagleXOrigin = 1280;
	private int turtleCount = 3;

	int[] question;
	int[] indexChoicesHolder;
	int[] indexChoicesNumber;
	ArrayList<Integer> indexChoicesPosition;

	private MenuScene menuChildScene;
	private MenuScene menuCompleteChildScene;
	private final int MENU_CHECK = 0;
	private final int MENU_RESET = 1;
	private final int MENU_COMPLETE = 2;
	private final int MENU_STAGE_RESET = 3;

	private final int STAGE_ID = 1;
	private int mysteryBoxCount = 1;
	private final int REWARD_ID = 1;

	private Music oceanMusic;
	private Sound beepSound, falseSound, applauseSound, screamSound1,
			screamSound2;

	private LevelCompleteWindow levelCompleteWindow;

	private int currentEagleNumber;

	// MoveXModifier[] moveXEagle = new MoveXModifier[3];
	// long[] EAGLE_ANIMATE = new long[] { 3000, 100, 100, 100 };

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createSound();
		createBackground();
		initializeTexture();
		// DataManager.getInstance().resetMysteryBox();
		// createGameOverText();
		levelCompleteWindow = new LevelCompleteWindow(completeTurtle, vbom);
		startGame();
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		// Music backsound = resourcesManager.backSound;
		// backsound.play();
		// SceneManager.getInstance()
		// .loadGarisBilanganStageMenuScene(engine, this);
		// resourcesManager.jungleMusic.stop();
		// oceanMusic.stop();
		// applauseSound.stop();
		SceneManager.getInstance()
				.loadGarisBilanganStageMenuSceneFromGameScene(engine);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_GAME;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
	}

	private void createSound() {
		beepSound = resourcesManager.beepSound;
		oceanMusic = resourcesManager.oceanMusic;
		applauseSound = resourcesManager.applauseSound;
		falseSound = resourcesManager.falseSound;
		screamSound1 = resourcesManager.screamSound1;
		screamSound2 = resourcesManager.screamSound2;

		oceanMusic.play();
	}

	private void createBackground() {
		// TODO Auto-generated method stub
		attachChild(new Sprite(640, 400,
				resourcesManager.garis_bilangan_game_scene_background_region,
				vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void initializeTexture() {
		// final Rectangle[] whiteRectangle = new Rectangle[10];
		// final Rectangle[] blackRectangle = new Rectangle[10];
		// ITextureRegion[] region = new ITextureRegion[14];
		ITiledTextureRegion[] turtleTiledTextureRegions = new ITiledTextureRegion[3];
		ITiledTextureRegion[] completeTurtleTiledTextureRegions = new ITiledTextureRegion[3];
		// number = new Sprite[14];
		// numberHolder = new Number[14];
		swappableNumberHolder = new SwappableNumber[14];

		eagleXOrigin = 1280;

		false_sign = new Sprite(640, 340,
				resourcesManager.game_scene_false_region, vbom);
		attachChild(false_sign);
		line = new Sprite(640, 720, resourcesManager.line_region, vbom);
		mystery_box = new Sprite(550, 200,
				resourcesManager.game_scene_mystery_box_region, vbom) {
			@Override
			protected void onManagedUpdate(float pSecondsElapsed) {
				// TODO Auto-generated method stub
				super.onManagedUpdate(pSecondsElapsed);
				if (this.collidesWith(eagle[0])) {
					this.setPosition(100, 700);
					this.setVisible(false);
					mysteryBoxCount--;
				}
			}
		};
		mystery_box.registerEntityModifier(new LoopEntityModifier(
				new ScaleModifier(1, 1, 1.3f)));

		mysteryBoxCount = 1;
		if (mysteryBoxCount == 1) {
			Reward reward = databaseHandler.getSingleReward(REWARD_ID);
			if (reward.getStatus() == DatabaseHandler.REWARD_LOCKED) {
				attachChild(mystery_box);
				// mystery_box.setPosition(200, 0);
				// mystery_box.setVisible(false);
			} else if (reward.getStatus() == DatabaseHandler.REWARD_UNLOCKED) {
				// mystery_box.setVisible(false);
				mystery_box.setPosition(1200, 200);
				attachChild(mystery_box);
				// mysteryBoxCount = 0;
			}
		}

		turtleTiledTextureRegions[0] = resourcesManager.turtle_region1;
		turtleTiledTextureRegions[1] = resourcesManager.turtle_region2;
		turtleTiledTextureRegions[2] = resourcesManager.turtle_region3;
		completeTurtleTiledTextureRegions[0] = resourcesManager.complete_turtle_1_region;
		completeTurtleTiledTextureRegions[1] = resourcesManager.complete_turtle_2_region;
		completeTurtleTiledTextureRegions[2] = resourcesManager.complete_turtle_3_region;

		int turtleX = 400;
		turtle = new AnimatedSprite[3];
		for (int i = 0; i < turtle.length; i++) {
			turtle[i] = new AnimatedSprite(turtleX, 230,
					turtleTiledTextureRegions[i], vbom);
			turtleX -= 150;
		}

		int completeTurtleX = 600;
		completeTurtle = new AnimatedSprite[3];
		for (int i = 0; i < completeTurtle.length; i++) {
			completeTurtle[i] = new AnimatedSprite(completeTurtleX, 200,
					completeTurtleTiledTextureRegions[i], vbom);
			completeTurtleX -= 175;
		}

		int choicesHolderX = 75;
		int answerHolderX = 75;

		choicesHolder = new Sprite[11];
		answerHolder = new Sprite[11];

		for (int i = 0; i < choicesHolder.length; i++) {
			choicesHolder[i] = new Sprite(choicesHolderX, 520,
					resourcesManager.game_scene_holder_region, vbom);
			choicesHolderX += 113;
		}

		for (int i = 0; i < answerHolder.length; i++) {
			answerHolder[i] = new Sprite(answerHolderX, 641,
					resourcesManager.game_scene_holder_region, vbom);
			answerHolderX += 113;
		}

		int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		for (int i = 0; i < swappableNumberHolder.length; i++) {
			swappableNumberHolder[i] = new SwappableNumber(0, 0,
					resourcesManager.game_scene_number_holder_region, vbom,
					swappableNumberHolder, answerHolder, choicesHolder,
					numbers[i]);
		}

		for (int i = 0; i < choicesHolder.length; i++) {
			attachChild(choicesHolder[i]);
		}
		for (int i = 0; i < answerHolder.length; i++) {
			attachChild(answerHolder[i]);
		}
		// for (int i = 0; i < blackRectangle.length; i++) {
		// attachChild(blackRectangle[i]);
		// }

		attachChild(line);
		// attachChild(mystery_box);
		for (int i = 0; i < turtle.length; i++) {
			attachChild(turtle[i]);
		}

		// for (int i = 0; i < numberHolder.length; i++) {
		// attachChild(numberHolder[i]);
		// // number[i].setZIndex(0);
		// // sortChildren();
		// this.registerTouchArea(numberHolder[i]);
		// }

		for (int i = 0; i < swappableNumberHolder.length; i++) {
			attachChild(swappableNumberHolder[i]);
			this.registerTouchArea(swappableNumberHolder[i]);
		}

		false_sign.setVisible(false);

		menuChildScene = new MenuScene(camera);
		GameManager.createMenuChildScene(menuChildScene, MENU_CHECK,
				MENU_RESET, resourcesManager.game_scene_check_button_region,
				resourcesManager.game_scene_reset_button_region, vbom);
		setChildScene(menuChildScene);

		// createMenuChildScene();
		createMenuCompleteChildScene();
		menuChildScene.setOnMenuItemClickListener(new menuItemListener());

		question = new int[] { 0, 1, 2, 4, 8 };
		indexChoicesHolder = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		indexChoicesNumber = new int[] { 3, 5, 6, 7, 9, 10, 11, 12, 13 };
		indexChoicesPosition = new ArrayList<Integer>();

		// GameManager.setGarisBilanganQuestion(question, numberHolder,
		// answerHolder, this);
		// GameManager.setChoices(indexChoicesNumber, indexChoicesHolder,
		// numberHolder, choicesHolder, indexChoicesPosition);
		GameManager.setGarisBilanganQuestion(question, swappableNumberHolder,
				answerHolder, this);
		GameManager.setChoices(indexChoicesNumber, indexChoicesHolder,
				swappableNumberHolder, choicesHolder, indexChoicesPosition);

		// Number number = new Number(100, 600,
		// resourcesManager.number_holder_region, vbom, 10);
		// attachChild(number);

		setTouchAreaBindingOnActionDownEnabled(true);
	}

	//
	// private void createMenuChildScene() {
	// menuChildScene = new MenuScene(camera);
	// menuChildScene.setPosition(0, 0);
	//
	// final IMenuItem checkMenuItem = new ScaleMenuItemDecorator(
	// new SpriteMenuItem(
	// MENU_CHECK,
	// resourcesManager.garis_bilangan_game_scene_check_button_region,
	// vbom), 1.2f, 1);
	// final IMenuItem resetMenuItem = new ScaleMenuItemDecorator(
	// new SpriteMenuItem(
	// MENU_RESET,
	// resourcesManager.garis_bilangan_game_scene_reset_button_region,
	// vbom), 1.2f, 1);
	// checkMenuItem.registerEntityModifier(new MoveModifier(1.5f, 0, 500,
	// 0,
	// 0, EaseBounceOut.getInstance()));

	// menuChildScene.addMenuItem(checkMenuItem);
	// menuChildScene.addMenuItem(resetMenuItem);
	//
	// menuChildScene.buildAnimations();
	// menuChildScene.setBackgroundEnabled(false);
	//
	// resetMenuItem.setPosition(585, 80);
	// checkMenuItem.setPosition(695, 80);
	//
	// setChildScene(menuChildScene);
	// }

	private void createMenuCompleteChildScene() {
		menuCompleteChildScene = new MenuScene(camera);
		menuCompleteChildScene.setPosition(0, 0);

		final IMenuItem completeMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_COMPLETE,
						resourcesManager.complete_button_region, vbom), 1.2f, 1);
		final IMenuItem restartMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_STAGE_RESET,
						resourcesManager.restart_button_region, vbom), 1.2f, 1);

		menuCompleteChildScene.addMenuItem(completeMenuItem);
		menuCompleteChildScene.addMenuItem(restartMenuItem);
		menuCompleteChildScene.buildAnimations();
		menuCompleteChildScene.setBackgroundEnabled(false);

		completeMenuItem.setPosition(585, 80);
		restartMenuItem.setPosition(695, 80);
	}

	private boolean checkAnswer() {
		if (GameManager.checkGarisBilangan(swappableNumberHolder, answerHolder)) {
			false_sign.setVisible(false);
			eagle[0].detachSelf();
			eagle[1].detachSelf();
			eagle[2].detachSelf();
			onGameComplete(turtleCount, true);
			return true;
		} else {
			false_sign.setVisible(true);
			falseSound.play();
			return false;
		}
	}

	// private String countScore() {
	// int gameScore = 0;
	// int eagleXEnd = 0;
	// if (turtleCount == 3) {
	// eagleXEnd = Math.round(eagle[0].getX());
	// } else if (turtleCount == 2) {
	// eagleXEnd = Math.round(eagle[1].getX());
	// } else if (turtleCount == 1) {
	// eagleXEnd = Math.round(eagle[2].getX());
	// } else if (turtleCount == 0) {
	// gameScore = 0;
	// return "Score: " + gameScore;
	// }
	// gameScore = GameManager
	// .countScore(turtleCount, eagleXOrigin, eagleXEnd);
	// gameScore = GameManager.countScore(turtleCount, eagleXOrigin, eagle);
	// return "Score: " + gameScore;
	// }

	private int countScore() {
		return GameManager.countScore(turtleCount, eagleXOrigin, eagle);
	}

	private void startGame() {
		// final MoveXModifier moveXEagle0 = new MoveXModifier(20,
		// eagleXOrigin, turtle[0].getX());
		// final MoveXModifier moveXEagle1 = new MoveXModifier(20,
		// eagleXOrigin, turtle[1].getX());
		// final MoveXModifier moveXEagle2 = new MoveXModifier(20,
		// eagleXOrigin, turtle[2].getX());
		eagle = new AnimatedSprite[3];
		currentEagleNumber = 0;
		// final MoveXModifier[] moveXEagle = new MoveXModifier[3];
		// final long[] EAGLE_ANIMATE = new long[] { 3000, 100, 100, 100 };
		final MoveXModifier[] moveXEagle = new MoveXModifier[3];
		final long[] EAGLE_ANIMATE = new long[] { 3000, 100, 100, 100 };

		for (int i = 0; i < moveXEagle.length; i++) {
			moveXEagle[i] = new MoveXModifier(42, eagleXOrigin,
					turtle[i].getX());
		}

		eagle[0] = new AnimatedSprite(eagleXOrigin, 340,
				resourcesManager.eagle_region, vbom) {
			@Override
			protected void onManagedUpdate(float pSecondsElapsed) {
				// TODO Auto-generated method stub
				super.onManagedUpdate(pSecondsElapsed);
				if (this.collidesWith(turtle[0])) {
					this.setVisible(false);
					this.setPosition(700, 700);
//					screamSound2.play();
					turtle[0].setVisible(false);
					turtle[0].stopAnimation();
					turtleCount--;
					// eagle[1].registerEntityModifier(new MoveXModifier(5,
					// eagle[1].getX(), turtle[1].getX()));
					// moveXEagle1 = new MoveXModifier(20, eagle[1].getX(),
					// turtle[1].getX());
					currentEagleNumber = 1;
					eagle[1].registerEntityModifier(moveXEagle[1]);
					eagle[1].animate(EAGLE_ANIMATE, 0, 3, true);
					this.unregisterEntityModifier(moveXEagle[0]);
					final long[] TURTLE_ANIMATE_1 = new long[] { 10000, 1000 };
					turtle[1].animate(TURTLE_ANIMATE_1, 0, 1, true,
							new animationListener());
				}
			}
		};
		eagle[1] = new AnimatedSprite(eagleXOrigin, 340,
				resourcesManager.eagle_region, vbom) {
			@Override
			protected void onManagedUpdate(float pSecondsElapsed) {
				// TODO Auto-generated method stub
				super.onManagedUpdate(pSecondsElapsed);
				if (this.collidesWith(turtle[1])) {
					this.setVisible(false);
					this.setPosition(700, 700);
//					screamSound1.play();
					turtle[1].setVisible(false);
					turtle[1].stopAnimation();
					turtleCount--;
					// eagle[2].registerEntityModifier(new MoveXModifier(5,
					// eagle[2].getX(), turtle[0].getX()));
					// moveXEagle2 = new MoveXModifier(20, eagle[2].getX(),
					// turtle[2].getX());
					currentEagleNumber = 2;
					eagle[2].registerEntityModifier(moveXEagle[2]);
					eagle[2].animate(EAGLE_ANIMATE, 0, 3, true);
					this.unregisterEntityModifier(moveXEagle[1]);
					final long[] TURTLE_ANIMATE_2 = new long[] { 10000, 1000 };
					turtle[2].animate(TURTLE_ANIMATE_2, 0, 1, true,
							new animationListener());
				}
			}
		};
		eagle[2] = new AnimatedSprite(eagleXOrigin, 340,
				resourcesManager.eagle_region, vbom) {
			@Override
			protected void onManagedUpdate(float pSecondsElapsed) {
				// TODO Auto-generated method stub
				super.onManagedUpdate(pSecondsElapsed);
				if (this.collidesWith(turtle[2])) {
					turtleCount--;
//					screamSound2.play();
					turtle[2].setVisible(false);
					turtle[2].stopAnimation();
					onGameComplete(turtleCount, false);
					this.setVisible(false);
					this.setPosition(700, 700);
					this.unregisterEntityModifier(moveXEagle[2]);
				}
			}
		};
		// moveXEagle0 = new MoveXModifier(20, eagle[0].getX(),
		// turtle[0].getX());
		for (int i = 0; i < eagle.length; i++) {
			attachChild(eagle[i]);
		}
		eagle[0].registerEntityModifier(moveXEagle[0]);
		eagle[0].animate(EAGLE_ANIMATE, 0, 3, true);

		final long[] TURTLE_ANIMATE_0 = new long[] { 10000, 1000 };
		turtle[0]
				.animate(TURTLE_ANIMATE_0, 0, 1, true, new animationListener());
	}

	private void onGameComplete(int turtleCount, boolean winLose) {
		GameManager.onGameCompleteDetachChild(menuChildScene, turtle,
				swappableNumberHolder, mystery_box, this);

		setChildScene(menuCompleteChildScene);
		menuCompleteChildScene
				.setOnMenuItemClickListener(new menuItemListener());

		if (turtleCount > 0) {
			applauseSound.play();
		}

		int score = countScore();

		String scoreText = "Score: " + score;

		levelCompleteWindow.display(turtleCount, this, camera, scoreText,
				winLose);

		GameManager.onGameCompleteUpdateStageStatus(databaseHandler,
				levelCompleteWindow, STAGE_ID, REWARD_ID, score, turtleCount,
				mysteryBoxCount, mystery_box, this);

		if (mysteryBoxCount == 1) {
			attachChild(mystery_box);
			mystery_box.setPosition(250, 300);
			Reward reward = new Reward(REWARD_ID, 1);
			databaseHandler.updateReward(reward);
		}
	}

	private class animationListener implements IAnimationListener {

		@Override
		public void onAnimationStarted(AnimatedSprite pAnimatedSprite,
				int pInitialLoopCount) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onAnimationFrameChanged(AnimatedSprite pAnimatedSprite,
				int pOldFrameIndex, int pNewFrameIndex) {
			// TODO Auto-generated method stub
			if (pAnimatedSprite == turtle[0]
					&& pAnimatedSprite.getCurrentTileIndex() == 1) {
				screamSound2.play();
			} else if (pAnimatedSprite == turtle[1]
					&& pAnimatedSprite.getCurrentTileIndex() == 1) {
				screamSound1.play();
			} else if (pAnimatedSprite == turtle[2]
					&& pAnimatedSprite.getCurrentTileIndex() == 1) {
				screamSound2.play();
			}
		}

		@Override
		public void onAnimationLoopFinished(AnimatedSprite pAnimatedSprite,
				int pRemainingLoopCount, int pInitialLoopCount) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onAnimationFinished(AnimatedSprite pAnimatedSprite) {
			// TODO Auto-generated method stub

		}

	}

	private class menuItemListener implements IOnMenuItemClickListener {

		@Override
		public boolean onMenuItemClicked(MenuScene pMenuScene,
				IMenuItem pMenuItem, float pMenuItemLocalX,
				float pMenuItemLocalY) {
			// TODO Auto-generated method stub
			switch (pMenuItem.getID()) {
			case MENU_CHECK:
				if (!checkAnswer()) {
					GameManager.advanceEagle(eagle[currentEagleNumber], turtle[currentEagleNumber], currentEagleNumber);
//					eagle[currentEagle].clearEntityModifiers();
//					if (eagle[currentEagle].getX() < turtle[currentEagle]
//							.getX() + 300) {
//						eagle[currentEagle].setPosition(turtle[currentEagle]);
//					} else {
//						eagle[currentEagle].setPosition(
//								turtle[currentEagle].getX() + 300,
//								eagle[currentEagle].getY());
//						eagle[currentEagle]
//								.registerEntityModifier(new MoveXModifier(3,
//										eagle[currentEagle].getX(),
//										turtle[currentEagle].getX()));
//						turtle[currentEagle].setCurrentTileIndex(1);
//						if (currentEagle == 1) {
//							screamSound1.play();
//						} else {
//							screamSound2.play();
//						}
//					}
				}
				return true;
			case MENU_RESET:
				GameManager.resetChoicesPosition(indexChoicesNumber,
						swappableNumberHolder, choicesHolder,
						indexChoicesPosition);
				beepSound.play();
				return true;
			case MENU_COMPLETE:
				onBackKeyPressed();
				return true;
			case MENU_STAGE_RESET:
				// oceanMusic.stop();
				// applauseSound.stop();
				SceneManager.getInstance().resetGarisBilanganGameScene(engine,
						STAGE_ID);
				return true;
			default:
				return false;
			}
		}
	}
}