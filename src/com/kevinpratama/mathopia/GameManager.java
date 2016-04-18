package com.kevinpratama.mathopia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kevinpratama.mathopia.datamanager.DatabaseHandler;
import com.kevinpratama.mathopia.datamanager.Stage;

public class GameManager {

	public static void createMenuChildScene(MenuScene menuChildScene,
			int MENU_CHECK, int MENU_RESET, ITextureRegion checkButton,
			ITextureRegion resetButton, VertexBufferObjectManager vbom) {
		menuChildScene.setPosition(0, 0);

		final IMenuItem checkMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_CHECK, checkButton, vbom), 1.2f, 1);
		final IMenuItem resetMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_RESET, resetButton, vbom), 1.2f, 1);

		menuChildScene.addMenuItem(checkMenuItem);
		menuChildScene.addMenuItem(resetMenuItem);

		menuChildScene.buildAnimations();
		menuChildScene.setBackgroundEnabled(false);

		resetMenuItem.setPosition(585, 80);
		checkMenuItem.setPosition(695, 80);
	}

	public static int countScore(int turtleCount, int eagleXOrigin,
			int eagleXEnd) {
		return turtleCount * 2000 - (eagleXOrigin - eagleXEnd);
	}

	public static int countScore(int turtleCount, int eagleXOrigin,
			Sprite[] eagle) {
		int eagleXEnd = 0;
		int gameScore = 0;

		if (turtleCount == 3) {
			eagleXEnd = Math.round(eagle[0].getX());
		} else if (turtleCount == 2) {
			eagleXEnd = Math.round(eagle[1].getX());
		} else if (turtleCount == 1) {
			eagleXEnd = Math.round(eagle[2].getX());
		} else if (turtleCount == 0) {
			gameScore = 0;
			return gameScore;
		}

		return turtleCount * 2000 - (eagleXOrigin - eagleXEnd);
	}

	public static boolean checkGarisBilangan(Sprite[] number,
			Sprite[] answerHolder) {
		int count = 0;
		for (int i = 0; i < answerHolder.length; i++) {
			if (number[i].collidesWith(answerHolder[i])) {
				count++;
			}
		}
		if (count == answerHolder.length) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkPenjumlahan(Number[] number,
			Sprite[] questionHolder, int userAnswer) {

		int[] nn = new int[questionHolder.length];

		for (int i = 0; i < nn.length; i++) {
			nn[i] = -1;
		}

		for (int i = 0; i < questionHolder.length; i++) {
			for (int j = 0; j < number.length; j++) {
				if (questionHolder[i].collidesWith(number[j])) {
					nn[i] = number[j].getNumber();
					break;
				}
			}
		}

		int total = 0;
		for (int i = 0; i < nn.length; i++) {
			total += nn[i];
		}

		if (userAnswer == total) {
			return true;
		}
		return false;
	}

	public static boolean checkPenjumlahan(SwappableNumber[] swappablenumber,
			Sprite[] answerHolder, int answer) {

		int[] nn = new int[answerHolder.length];

		for (int i = 0; i < nn.length; i++) {
			nn[i] = -1;
		}

		for (int i = 0; i < answerHolder.length; i++) {
			for (int j = 0; j < swappablenumber.length; j++) {
				if (answerHolder[i].collidesWith(swappablenumber[j])) {
					nn[i] = swappablenumber[j].getNumber();
					break;
				}
			}
		}

		int total = 0;
		for (int i = 0; i < nn.length; i++) {
			total += nn[i];
		}

		if (answer == total) {
			return true;
		}
		return false;
	}

	public static boolean checkPengurangan(Number[] number,
			Sprite[] answerHolder, int answer) {

		int[] nn = new int[answerHolder.length];

		for (int i = 0; i < nn.length; i++) {
			nn[i] = -1;
		}

		for (int i = 0; i < answerHolder.length; i++) {
			for (int j = 0; j < number.length; j++) {
				if (answerHolder[i].collidesWith(number[j])) {
					nn[i] = number[j].getNumber();
					break;
				}
			}
		}

		int total = nn[0];
		for (int i = 1; i < nn.length; i++) {
			total -= nn[i];
		}

		if (answer == total) {
			return true;
		}
		return false;
	}

	public static boolean checkPerkalian(Number[] number,
			Sprite[] answerHolder, int answer) {

		int[] nn = new int[answerHolder.length];

		for (int i = 0; i < nn.length; i++) {
			nn[i] = -1;
		}

		for (int i = 0; i < answerHolder.length; i++) {
			for (int j = 0; j < number.length; j++) {
				if (answerHolder[i].collidesWith(number[j])) {
					nn[i] = number[j].getNumber();
					break;
				}
			}
		}

		int total = 1;
		for (int i = 0; i < nn.length; i++) {
			if (i == 2) {
				total /= nn[i];
			} else {
				total *= nn[i];
			}
		}

		if (answer == total) {
			return true;
		}
		return false;
	}

	public static boolean checkPembagian(Number[] number,
			Sprite[] answerHolder, int answer) {

		int[] nn = new int[answerHolder.length];

		for (int i = 0; i < nn.length; i++) {
			nn[i] = 1;
		}

		for (int i = 0; i < answerHolder.length; i++) {
			for (int j = 0; j < number.length; j++) {
				if (answerHolder[i].collidesWith(number[j])) {
					nn[i] = number[j].getNumber();
					break;
				}
			}
		}

		int total = 1;
		for (int i = 0; i < nn.length; i++) {
			if (i == 2) {
				total *= nn[i];
			} else if (i == 0) {
				total = nn[i];
			} else {
				total /= nn[i];
			}
		}

		if (answer == total) {
			return true;
		}
		return false;
	}

	public static boolean isCollide(Sprite sprite, Sprite[] number,
			Sprite[] answerHolder, Sprite[] choicesHolder) {
		// TODO Auto-generated method stub

		for (int i = 0; i < number.length; i++) {
			if (sprite != number[i]) {
				if (sprite.collidesWith(number[i])) {
					return false;
				}
			}
		}

		for (int i = 0; i < answerHolder.length; i++) {

			if (sprite.collidesWith(answerHolder[i])) {
				sprite.setPosition(answerHolder[i].getX(),
						answerHolder[i].getY());
				return true;
			} else if (sprite.collidesWith(choicesHolder[i])) {
				sprite.setPosition(choicesHolder[i].getX(),
						choicesHolder[i].getY());
				return true;
			}
		}
		return false;
	}

	public static boolean isCollide(Sprite sprite, Sprite[] number,
			Sprite[] answerHolder, Sprite[] choicesHolder, Sprite[] mathSymbol) {
		// TODO Auto-generated method stub

		for (int i = 0; i < number.length; i++) {
			if (sprite != number[i]) {
				if (sprite.collidesWith(number[i])) {
					return false;
				}
			}
		}

		for (int i = 0; i < mathSymbol.length; i++) {
			if (sprite.collidesWith(mathSymbol[i])) {
				return false;
			}
		}

		for (int i = 0; i < answerHolder.length; i++) {

			if (sprite.collidesWith(answerHolder[i])) {
				sprite.setPosition(answerHolder[i].getX(),
						answerHolder[i].getY());
				// answerHolder[i].attachChild(sprite);
				// sprite.setParent(answerHolder[i]);
				return true;
			} else if (sprite.collidesWith(choicesHolder[i])) {
				sprite.setPosition(choicesHolder[i].getX(),
						choicesHolder[i].getY());
				// choicesHolder[i].attachChild(sprite);
				// sprite.setParent(answerHolder[i]);
				return true;
			}
		}
		return false;
	}

	public static boolean isCollide(SwappableNumber swappableNumber,
			SwappableNumber[] swappableNumbers, Sprite[] answerHolder,
			Sprite[] choicesHolder, MathSymbol[] mathSymbols) {
		// TODO Auto-generated method stub

		for (int i = 0; i < swappableNumbers.length; i++) {
			if (swappableNumber != swappableNumbers[i]) {
				if (swappableNumber.collidesWith(swappableNumbers[i])) {
					if (swappableNumber.isSwappable()
							&& swappableNumbers[i].isSwappable()) {
						float x1 = swappableNumber.getOriginX();
						float x2 = swappableNumbers[i].getX();
						float y1 = swappableNumber.getOriginY();
						float y2 = swappableNumbers[i].getY();

						swappableNumber.setPosition(x2, y2);
						swappableNumbers[i].setPosition(x1, y1);
						return true;
					} else {
						return false;
					}
				}
			}
		}

		for (int i = 0; i < mathSymbols.length; i++) {
			if (swappableNumber.collidesWith(mathSymbols[i])) {
				return false;
			}
		}

		for (int i = 0; i < answerHolder.length; i++) {

			if (swappableNumber.collidesWith(answerHolder[i])) {
				swappableNumber.setPosition(answerHolder[i].getX(),
						answerHolder[i].getY());
				return true;
			} else if (swappableNumber.collidesWith(choicesHolder[i])) {
				swappableNumber.setPosition(choicesHolder[i].getX(),
						choicesHolder[i].getY());
				return true;
			}
		}
		return false;
	}

	public static void setGarisBilanganQuestion(int[] question,
			Sprite[] number, Sprite[] answerHolder, BaseScene scene) {

		for (int i = 0; i < question.length; i++) {
			number[question[i]].setPosition(answerHolder[question[i]].getX(),
					answerHolder[question[i]].getY());
			scene.unregisterTouchArea(number[question[i]]);
		}
	}

	public static void setGarisBilanganQuestion(int[] question,
			SwappableNumber[] swappableNumbers, Sprite[] answerHolder,
			BaseScene scene) {

		for (int i = 0; i < question.length; i++) {
			swappableNumbers[question[i]].setPosition(
					answerHolder[question[i]].getX(),
					answerHolder[question[i]].getY());
			swappableNumbers[question[i]].setSwappable(false);
			swappableNumbers[question[i]].setTextColor(0.4f, 0.1f, 0.7f);
			scene.unregisterTouchArea(swappableNumbers[question[i]]);
		}
	}

	public static void setPenjumlahanQuestion3(int[] question, Sprite[] number,
			Sprite[] answerHolder, Sprite[] mathSymbols,
			Sprite[] mathSymbolsHolder, Sprite[] detachHolder, BaseScene scene) {

		for (int i = 0; i < question.length; i++) {
			number[question[i]].setPosition(answerHolder[i]);
			scene.unregisterTouchArea(number[question[i]]);
		}

		for (int i = 0; i < mathSymbols.length; i++) {
			mathSymbols[i].setPosition(mathSymbolsHolder[i]);
		}

		for (int i = 0; i < detachHolder.length; i++) {
			detachHolder[i].setPosition(-100, -100);
			detachHolder[i].detachSelf();
		}

	}

	public static void setPenjumlahanQuestion3(int[] question,
			SwappableNumber[] swappableNumbers, Sprite[] answerHolder,
			Sprite[] mathSymbols, Sprite[] mathSymbolsHolder,
			Sprite[] detachHolder, BaseScene scene) {

		for (int i = 0; i < question.length; i++) {
			swappableNumbers[question[i]].setPosition(answerHolder[i]);
			swappableNumbers[question[i]].setSwappable(false);
			swappableNumbers[question[i]].setTextColor(0.4f, 0.1f, 0.7f);
			scene.unregisterTouchArea(swappableNumbers[question[i]]);
		}

		for (int i = 0; i < mathSymbols.length; i++) {
			mathSymbols[i].setPosition(mathSymbolsHolder[i]);
		}

		for (int i = 0; i < detachHolder.length; i++) {
			detachHolder[i].setPosition(-100, -100);
			detachHolder[i].detachSelf();
		}

	}

	public static void setPenjumlahanQuestion4(int[] question,
			SwappableNumber[] swappableNumbers, Sprite[] answerHolder,
			Sprite[] mathSymbols, Sprite[] mathSymbolsHolder,
			Sprite[] detachHolder, BaseScene scene) {

		for (int i = 0; i < question.length; i++) {
			swappableNumbers[question[i]].setPosition(answerHolder[i]);
			swappableNumbers[question[i]].setSwappable(false);
			// swappableNumbers[question[i]].setTextColor(0.4f, 0.1f, 0.7f);
			scene.unregisterTouchArea(swappableNumbers[question[i]]);
		}

		for (int i = 0; i < mathSymbols.length; i++) {
			mathSymbols[i].setPosition(mathSymbolsHolder[i]);
		}

		for (int i = 0; i < detachHolder.length; i++) {
			detachHolder[i].setPosition(-100, -100);
			detachHolder[i].detachSelf();
		}

	}

	public static void resetChoicesPosition(int[] indexChoicesNumber,
			Sprite[] number, Sprite[] choicesHolder,
			ArrayList<Integer> indexChoicesPosition) {

		for (int i = 0; i < indexChoicesNumber.length; i++) {
			number[indexChoicesNumber[i]]
					.setPosition(
							choicesHolder[indexChoicesPosition.get(i)]
									.getX(),
							choicesHolder[indexChoicesPosition.get(i)]
									.getY());
		}
	}

	public static void setChoices(int[] indexChoiceNumber,
			int[] indexChoicesHolder, Sprite[] number, Sprite[] choicesHolder,
			ArrayList<Integer> indexChoicesPosition) {

		for (int i = 0; i < indexChoicesHolder.length; i++) {
			indexChoicesPosition.add(indexChoicesHolder[i]);
		}

		Collections.shuffle(indexChoicesPosition);

		GameManager.resetChoicesPosition(indexChoiceNumber, number,
				choicesHolder, indexChoicesPosition);

		if (indexChoicesHolder.length < 9) {
			choicesHolder[0].setPosition(-100, -100);
			choicesHolder[0].detachSelf();
			choicesHolder[1].setPosition(-100, -100);
			choicesHolder[1].detachSelf();
			choicesHolder[9].setPosition(-100, -100);
			choicesHolder[9].detachSelf();
			choicesHolder[10].setPosition(-100, -100);
			choicesHolder[10].detachSelf();
		} else if (indexChoicesHolder.length < 11) {
			choicesHolder[0].setPosition(-100, -100);
			choicesHolder[0].detachSelf();
			choicesHolder[10].setPosition(-100, -100);
			choicesHolder[10].detachSelf();
		}
	}

	public static void setPembagianChoices(int[] indexChoiceNumber,
			int[] indexChoicesHolder, Sprite[] number, Sprite[] choicesHolder,
			ArrayList<Integer> indexChoicesPosition) {

		for (int i = 0; i < indexChoicesHolder.length; i++) {
			indexChoicesPosition.add(indexChoicesHolder[i]);
		}

		Collections.shuffle(indexChoicesPosition);

		GameManager.resetChoicesPosition(indexChoiceNumber, number,
				choicesHolder, indexChoicesPosition);

		// if (indexChoicesHolder.length < 9) {1,4,7,10 0, 2,3, 5, 6, 8,9 ,11
		choicesHolder[0].setPosition(-100, -100);
		choicesHolder[0].detachSelf();
		choicesHolder[2].setPosition(-100, -100);
		choicesHolder[2].detachSelf();
		choicesHolder[3].setPosition(-100, -100);
		choicesHolder[3].detachSelf();
		choicesHolder[5].setPosition(-100, -100);
		choicesHolder[5].detachSelf();
		choicesHolder[6].setPosition(-100, -100);
		choicesHolder[6].detachSelf();
		choicesHolder[8].setPosition(-100, -100);
		choicesHolder[8].detachSelf();
		choicesHolder[9].setPosition(-100, -100);
		choicesHolder[9].detachSelf();
	}

	public static void onGameCompleteUpdateStageStatus(
			DatabaseHandler databaseHandler,
			LevelCompleteWindow levelCompleteWindow, int STAGE_ID,
			int REWARD_ID, int score, int turtleCount, int mysteryBoxCount,
			Sprite mystery_box, BaseScene scene) {

		Stage stage = databaseHandler.getSingleStage(STAGE_ID);

		int count = 0;
		if (score > stage.getScore()) {
			levelCompleteWindow.setHighScoreVisible(true);
			stage.setScore(score);
			count++;
		}

		if (turtleCount > stage.getTurtleSaved()) {
			stage.setTurtleSaved(turtleCount);
			count++;
		}
		if (count > 0) {
			ResourceManager.getInstance().gTracker.sendEvent("Stage Finish",
					"Note Stage Status", "Stage ID: " + stage.getId()
							+ " Stage Score: " + stage.getScore()
							+ " Stage Turtle: " + stage.getTurtleSaved(),
					(long) 0);
			databaseHandler.updateStage(stage);
			Stage lockedStage;
			if (STAGE_ID % 10 != 0) {

				int startId = 0;
				if (STAGE_ID < 10) {
					lockedStage = databaseHandler.getSingleStage(10);
					startId = DatabaseHandler.GARIS_BILANGAN_STAGE_START_ID;
				} else if (STAGE_ID < 20) {
					lockedStage = databaseHandler.getSingleStage(20);
					startId = DatabaseHandler.PENJUMLAHAN_STAGE_START_ID;
				} else if (STAGE_ID < 30) {
					lockedStage = databaseHandler.getSingleStage(30);
					startId = DatabaseHandler.PENGURANGAN_STAGE_START_ID;
				} else if (STAGE_ID < 40) {
					lockedStage = databaseHandler.getSingleStage(40);
					startId = DatabaseHandler.PERKALIAN_STAGE_START_ID;
				} else {
					lockedStage = databaseHandler.getSingleStage(50);
					startId = DatabaseHandler.PEMBAGIAN_STAGE_START_ID;
				}

				if (lockedStage.getStatus() == DatabaseHandler.STAGE_LOCKED) {

					int totalScore = 0;
					int totalTurtle = 0;
					List<Stage> stages = databaseHandler.getStages(startId);

					for (int i = 0; i < stages.size() - 1; i++) {
						totalScore += stages.get(i).getScore();
						totalTurtle += stages.get(i).getTurtleSaved();
					}

					if (totalScore > 40000 && totalTurtle > 20) {
						lockedStage.setStatus(DatabaseHandler.STAGE_UNLOCKED);
					}

					databaseHandler.updateStage(lockedStage);
				}
			}
			// if (mysteryBoxCount == 1) {
			// scene.attachChild(mystery_box);
			// mystery_box.setPosition(250, 300);
			// Reward reward = new Reward(REWARD_ID, 1);
			// databaseHandler.updateReward(reward);
			// }
		}
	}

	public static void onGameCompleteDetachChild(MenuScene menuChildScene,
			AnimatedSprite[] turtle, Sprite[] number, Sprite mystery_box,
			BaseScene scene) {

		menuChildScene.detachChildren();
		menuChildScene.setOnMenuItemClickListener(null);

		for (int i = 0; i < turtle.length; i++) {
			turtle[i].detachSelf();
		}

		mystery_box.detachSelf();

		for (int i = 0; i < number.length; i++) {
			scene.unregisterTouchArea(number[i]);
		}
	}

	public static void setStageStatus(IMenuItem[] menuItem,
			AnimatedSprite[] medal, List<Stage> stageList, Font font,
			VertexBufferObjectManager vbom) {

		Text[] score = new Text[10];

		for (int i = 0; i < score.length; i++) {
			score[i] = new Text(0, 0, font, "9999", vbom);
			score[i].setColor(0.376f, 0.22f, 0.075f);
			score[i].setText("" + stageList.get(i).getScore());
			menuItem[i].attachChild(score[i]);
			score[i].setPosition(menuItem[i].getWidth() / 2,
					menuItem[i].getHeight() / 2);
		}

		int turtleSaved = 0;
		for (int i = 0; i < menuItem.length; i++) {
			turtleSaved = stageList.get(i).getTurtleSaved();

			if (turtleSaved == 0) {
				medal[i].setCurrentTileIndex(0);
			} else if (turtleSaved == 1) {
				medal[i].setCurrentTileIndex(1);
			} else if (turtleSaved == 2) {
				medal[i].setCurrentTileIndex(2);
			} else if (turtleSaved == 3) {
				medal[i].setCurrentTileIndex(3);
			}

			menuItem[i].attachChild(medal[i]);
			medal[i].setPosition(menuItem[i].getWidth() / 2, 0);
		}
	}

	public static boolean checkLockedStage(List<Stage> stage) {
		Stage s = stage.get(stage.size() - 1);
		if (s.getStatus() == DatabaseHandler.STAGE_LOCKED) {
			return true;
		} else {
			return false;
		}
	}

	public static int countTotalScore(List<Stage> stages) {
		int totalScore = 0;

		for (int i = 0; i < stages.size() - 1; i++) {
			totalScore += stages.get(i).getScore();
		}

		return totalScore;
	}

	public static int countTotalTurtle(List<Stage> stages) {
		int totalTurtle = 0;

		for (int i = 0; i < stages.size() - 1; i++) {
			totalTurtle += stages.get(i).getTurtleSaved();
		}

		return totalTurtle;
	}

	public static Sprite createLockMenuItem(List<Stage> stage,
			AnimatedSprite medal, ResourceManager resourcesManager,
			VertexBufferObjectManager vbom) {
		Sprite lock = new Sprite(0, 0, 170, 128,
				resourcesManager.stage_select_1_region, vbom);
		
		Sprite lockSymbol = new Sprite(0, 0, resourcesManager.lock_region, vbom);

		int totalScore = GameManager.countTotalScore(stage);
		int totalTurtle = GameManager.countTotalTurtle(stage);

		Text scoreText = new Text(0, 0, resourcesManager.menuFont, totalScore
				+ " / 40000", vbom);
		Text turtleText = new Text(0, 0, resourcesManager.menuFont, "Turtle",
				vbom);
		Text turtleCountText = new Text(0, 0, resourcesManager.menuFont,
				totalTurtle + " / 20", vbom);

		lock.attachChild(scoreText);
		lock.attachChild(turtleText);
		lock.attachChild(turtleCountText);
		lock.attachChild(medal);
		lock.attachChild(lockSymbol);

		scoreText.setPosition(lock.getX() + lock.getWidth() / 2, lock.getY()
				+ lock.getHeight() / 2 + 22);
		turtleText.setPosition(scoreText.getX(),
				scoreText.getY() - turtleText.getHeight() + 7);
		turtleCountText.setPosition(turtleText.getX(), turtleText.getY()
				- turtleCountText.getHeight() + 10);

		scoreText.setColor(0.376f, 0.22f, 0.075f);
		scoreText.setScale(0.7f);
		turtleText.setColor(0.376f, 0.22f, 0.075f);
		turtleText.setScale(0.7f);
		turtleCountText.setColor(0.376f, 0.22f, 0.075f);
		turtleCountText.setScale(0.7f);

		medal.setPosition(lock.getX() + lock.getWidth() / 2, 0);
		medal.setCurrentTileIndex(0);
		
		lockSymbol.setPosition(lock.getWidth() - 25, lock.getHeight());

		return lock;
	}
	
	public static void advanceEagle(AnimatedSprite currentEagle, AnimatedSprite currentTurtle, int currentEagleNumber){
		currentEagle.clearEntityModifiers();
		if (currentEagle.getX() < currentTurtle
				.getX() + 300) {
			currentEagle.setPosition(currentTurtle);
		} else {
			currentEagle.setPosition(
					currentTurtle.getX() + 300,
					currentEagle.getY());
			currentEagle
					.registerEntityModifier(new MoveXModifier(3,
							currentEagle.getX(),
							currentTurtle.getX()));
			currentTurtle.setCurrentTileIndex(1);
			if (currentEagleNumber == 1) {
				ResourceManager.getInstance().screamSound1.play();
			} else {
				ResourceManager.getInstance().screamSound2.play();
			}
		}
	}

}
