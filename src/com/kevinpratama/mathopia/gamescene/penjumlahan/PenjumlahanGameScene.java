package com.kevinpratama.mathopia.gamescene.penjumlahan;

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
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.AnimatedSprite.IAnimationListener;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.util.GLState;

import com.kevinpratama.mathopia.BaseScene;
import com.kevinpratama.mathopia.GameManager;
import com.kevinpratama.mathopia.LevelCompleteWindow;
import com.kevinpratama.mathopia.MathSymbol;
import com.kevinpratama.mathopia.SceneManager;
import com.kevinpratama.mathopia.SwappableNumber;
import com.kevinpratama.mathopia.SceneManager.SceneType;
import com.kevinpratama.mathopia.datamanager.DatabaseHandler;
import com.kevinpratama.mathopia.datamanager.Reward;

public class PenjumlahanGameScene extends BaseScene {
	private Sprite[] choicesHolder, answerHolder;
//	private Number[] numberHolder;
	private SwappableNumber[] swappableNumbers;
	private MathSymbol[] mathSymbols;
	private AnimatedSprite[] turtle, completeTurtle, eagle;
	private Sprite false_sign, mystery_box;

	private int eagleXOrigin = 1280;
	private int turtleCount = 3;

	private int[] question;
	private int[] indexChoicesHolder;
	private int[] indexChoicesNumber;
	private ArrayList<Integer> indexChoicesPosition;

	private MenuScene menuChildScene;
	private MenuScene menuCompleteChildScene;
	private final int MENU_CHECK = 0;
	private final int MENU_RESET = 1;
	private final int MENU_COMPLETE = 2;
	private final int MENU_STAGE_RESET = 3;

	private final int STAGE_ID = 11;
	private int mysteryBoxCount = 1;
	private final int REWARD_ID = 3;
	private final int answer = 2508;

	private Music mountainMusic;
	private Sound beepSound, falseSound, applauseSound, screamSound1,
			screamSound2;

	private LevelCompleteWindow levelCompleteWindow;
	
	private int currentEagleNumber;
	
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
		SceneManager.getInstance().loadPenjumlahanStageMenuSceneFromGameScene(
				engine);
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
		mountainMusic = resourcesManager.mountainMusic;
		applauseSound = resourcesManager.applauseSound;
		falseSound = resourcesManager.falseSound;
		screamSound1 = resourcesManager.screamSound1;
		screamSound2 = resourcesManager.screamSound2;

		mountainMusic.play();
	}

	private void createBackground() {
		// TODO Auto-generated method stub
		attachChild(new Sprite(640, 400,
				resourcesManager.penjumlahan_game_scene_background_region, vbom) {
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

		eagleXOrigin = 1280;

		false_sign = new Sprite(640, 340,
				resourcesManager.game_scene_false_region, vbom);
		attachChild(false_sign);
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

		// numberHolder = new Number[10];
		// choicesHolder = new Sprite[11];
		// answerHolder = new Sprite[5];

//		numberHolder = new Number[10];
		swappableNumbers = new SwappableNumber[10];
		mathSymbols = new MathSymbol[4];
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

		// TODO revised!!
		mathSymbols[0] = new MathSymbol(0, 0,
				resourcesManager.game_scene_number_holder_region, vbom, "=");
		mathSymbols[1] = new MathSymbol(0, 0,
				resourcesManager.game_scene_number_holder_region, vbom, "+");
		mathSymbols[2] = new MathSymbol(0, 0,
				resourcesManager.game_scene_number_holder_region, vbom, "+");
		mathSymbols[3] = new MathSymbol(0, 0,
				resourcesManager.game_scene_number_holder_region, vbom, "+");

		int[] numbers = { 2508, 1000, 2000, 500, 400, 10, 0, 9, 8, 7 };
		// int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

		for (int i = 0; i < swappableNumbers.length; i++) {
			swappableNumbers[i] = new SwappableNumber(0, 0,
					resourcesManager.game_scene_number_holder_region, vbom,
					swappableNumbers, answerHolder, choicesHolder, mathSymbols,
					numbers[i]);
		}

		for (int i = 0; i < choicesHolder.length; i++) {
			attachChild(choicesHolder[i]);
		}
		for (int i = 0; i < answerHolder.length; i++) {
			attachChild(answerHolder[i]);
		}

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
		
		for (int i = 0; i < turtle.length; i++) {
			attachChild(turtle[i]);
		}
		
		for (int i = 0; i < mathSymbols.length; i++) {
			attachChild(mathSymbols[i]);
		}

		for (int i = 0; i < swappableNumbers.length; i++) {
			attachChild(swappableNumbers[i]);
			this.registerTouchArea(swappableNumbers[i]);
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

		Sprite[] answerHolder = new Sprite[1];
		answerHolder[0] = this.answerHolder[1];
		
		Sprite[] mathSymbolsHolder = new Sprite[4];
		mathSymbolsHolder[0] = this.answerHolder[2];
		mathSymbolsHolder[1] = this.answerHolder[4];
		mathSymbolsHolder[2] = this.answerHolder[6];
		mathSymbolsHolder[3] = this.answerHolder[8];
		
		Sprite[] detachHolder = new Sprite[2];
		detachHolder[0] = this.answerHolder[0];
		detachHolder[1] = this.answerHolder[10];
		
		question = new int[] { 0 };
		indexChoicesHolder = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		indexChoicesNumber = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// question = new int[] { 0, 1, 2, 4, 8 };
		// indexChoicesHolder = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// indexChoicesNumber = new int[] { 3, 5, 6, 7, 9, 10, 11, 12, 13 };
		indexChoicesPosition = new ArrayList<Integer>();

		GameManager.setPenjumlahanQuestion3(question, swappableNumbers,
				answerHolder, mathSymbols, mathSymbolsHolder, detachHolder, this);
		GameManager.setChoices(indexChoicesNumber, indexChoicesHolder,
				swappableNumbers, choicesHolder, indexChoicesPosition);

		// Number number = new Number(100, 600,
		// resourcesManager.number_holder_region, vbom, 10);
		// attachChild(number);

		setTouchAreaBindingOnActionDownEnabled(true);
	}

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
		Sprite[] answerHolder = new Sprite[4];
		answerHolder[0] = this.answerHolder[3];
		answerHolder[1] = this.answerHolder[5];
		answerHolder[2] = this.answerHolder[7];
		answerHolder[3] = this.answerHolder[9];
		
		if (GameManager.checkPenjumlahan(swappableNumbers, answerHolder, answer)) {
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

	private int countScore() {
		return GameManager.countScore(turtleCount, eagleXOrigin, eagle);
	}

	private void startGame() {
		currentEagleNumber = 0;
		eagle = new AnimatedSprite[3];
		final MoveXModifier[] moveXEagle = new MoveXModifier[3];
		final long[] EAGLE_ANIMATE = new long[] { 3000, 100, 100, 100 };

		for (int i = 0; i < moveXEagle.length; i++) {
			moveXEagle[i] = new MoveXModifier(32, eagleXOrigin,
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
					turtle[0].setVisible(false);
					turtle[0].stopAnimation();
					turtleCount--;
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
					turtle[1].setVisible(false);
					turtle[1].stopAnimation();
					turtleCount--;
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
					turtle[2].setVisible(false);
					turtle[2].stopAnimation();
					onGameComplete(turtleCount, false);
					this.setVisible(false);
					this.setPosition(700, 700);
					this.unregisterEntityModifier(moveXEagle[2]);
				}
			}
		};
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
				swappableNumbers, mystery_box, this);

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
				if(!checkAnswer()){
					GameManager.advanceEagle(eagle[currentEagleNumber], turtle[currentEagleNumber], currentEagleNumber);
				}
				return true;
			case MENU_RESET:
//				eagle[currentEagleNumber].clearEntityModifiers();
//				if (eagle[currentEagleNumber].getX() < turtle[currentEagleNumber].getX() + 300) {
//					eagle[currentEagleNumber].setPosition(turtle[currentEagleNumber]);
//				} else {
//					eagle[currentEagleNumber].setPosition(
//							turtle[currentEagleNumber].getX() + 300,
//							eagle[currentEagleNumber].getY());
//					eagle[currentEagleNumber]
//							.registerEntityModifier(new MoveXModifier(5,
//									eagle[currentEagleNumber].getX(),
//									turtle[currentEagleNumber].getX()));
//				}
				GameManager.resetChoicesPosition(indexChoicesNumber,
						swappableNumbers, choicesHolder, indexChoicesPosition);
				beepSound.play();
				return true;
			case MENU_COMPLETE:
				onBackKeyPressed();
				return true;
			case MENU_STAGE_RESET:
				SceneManager.getInstance().resetPenjumlahanGameScene(engine,
						STAGE_ID);
				return true;
			default:
				return false;
			}
		}
	}
}
