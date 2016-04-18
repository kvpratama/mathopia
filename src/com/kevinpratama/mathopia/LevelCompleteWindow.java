package com.kevinpratama.mathopia;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.AnimatedSprite.IAnimationListener;
import org.andengine.entity.text.Text;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class LevelCompleteWindow extends Sprite {
	private AnimatedSprite[] completeTurtle;
	private Sprite highScore;
	private Text score, winLose;

	// public enum TurtleCount {
	// ONE, TWO, THREE
	// }

	public LevelCompleteWindow(AnimatedSprite[] completeTurtle,
			VertexBufferObjectManager pSpriteVertexBufferObject) {
		super(0, 0, ResourceManager.getInstance().complete_window_region,
				pSpriteVertexBufferObject);
		this.completeTurtle = completeTurtle;
		attachCompleteTurtle(pSpriteVertexBufferObject);
		attachScore(pSpriteVertexBufferObject);
		attachHighScore(pSpriteVertexBufferObject);
		attachCompleteText(pSpriteVertexBufferObject);
	}

	private void attachCompleteTurtle(
			VertexBufferObjectManager pSpriteVertexBufferObject) {
		for (int i = 0; i < completeTurtle.length; i++) {
			attachChild(completeTurtle[i]);
		}
	}

	private void attachScore(VertexBufferObjectManager pSpriteVertexBufferObject) {
		score = new Text(425, 355, ResourceManager.getInstance().scoreFont,
				"score: 1234", pSpriteVertexBufferObject);
		attachChild(score);
	}

	private void attachHighScore(VertexBufferObjectManager pSpriteVertexBufferObject) {
		highScore = new Sprite(750, 300, ResourceManager.getInstance().game_scene_high_score_region, pSpriteVertexBufferObject);
		highScore.setVisible(false);
		attachChild(highScore);
	}
	
	public void setHighScoreVisible(boolean visible){
		highScore.setVisible(visible);
	}
	
	private void attachCompleteText(
			VertexBufferObjectManager pSpriteVertexBufferObject) {
		winLose = new Text(425, 520,
				ResourceManager.getInstance().stageCompleteFont,
				"  Stage\nCompleted", pSpriteVertexBufferObject);
		attachChild(winLose);
	}

	/**
	 * Change turtle`s tile index, depends on stars count.
	 * 
	 * @param turtleCount
	 */
	public void display(int turtleCount, Scene scene, Camera camera,
			String scoreText, Boolean winLose) {
		// Change stars tile index, based on stars count (1-3)
		final long[] TURTLE_ANIMATE_0 = new long[] { 2000, 500 };
		final long[] TURTLE_ANIMATE_1 = new long[] { 2500, 500 };
		final long[] TURTLE_ANIMATE_2 = new long[] { 1000, 500 };
		switch (turtleCount) {
		case 0:
//			complete_turtle1.setCurrentTileIndex(1);
//			complete_turtle2.setCurrentTileIndex(1);
//			complete_turtle3.setCurrentTileIndex(1);
			completeTurtle[0].setCurrentTileIndex(2);
			completeTurtle[1].setCurrentTileIndex(2);
			completeTurtle[2].setCurrentTileIndex(2);
			this.winLose.setColor(0.329f, 0.353f, 0.416f);
			this.winLose.setText("Stage \nFailed");
			break;
		case 1:
//			complete_turtle1.setCurrentTileIndex(0);
//			complete_turtle2.setCurrentTileIndex(1);
//			complete_turtle3.setCurrentTileIndex(1);
			completeTurtle[0].setCurrentTileIndex(2);
			completeTurtle[1].setCurrentTileIndex(2);
			completeTurtle[2].animate(TURTLE_ANIMATE_2, 0, 1, true, new animationListener());
//			completeTurtle[2].setCurrentTileIndex(1);
			break;
		case 2:
//			complete_turtle1.setCurrentTileIndex(0);
//			complete_turtle2.setCurrentTileIndex(0);
//			complete_turtle3.setCurrentTileIndex(1);
			completeTurtle[0].setCurrentTileIndex(2);
			completeTurtle[1].animate(TURTLE_ANIMATE_1, 0, 1, true, new animationListener());
			completeTurtle[2].animate(TURTLE_ANIMATE_2, 0, 1, true, new animationListener());
//			completeTurtle[1].setCurrentTileIndex(0);
//			completeTurtle[2].setCurrentTileIndex(1);
			break;
		case 3:
//			complete_turtle1.setCurrentTileIndex(0);
//			complete_turtle2.setCurrentTileIndex(0);
//			complete_turtle3.setCurrentTileIndex(0);
			completeTurtle[0].animate(TURTLE_ANIMATE_0, 0, 1, true, new animationListener());
			completeTurtle[1].animate(TURTLE_ANIMATE_1, 0, 1, true, new animationListener());
			completeTurtle[2].animate(TURTLE_ANIMATE_2, 0, 1, true, new animationListener());
//			completeTurtle[0].setCurrentTileIndex(0);
//			completeTurtle[1].setCurrentTileIndex(0);
//			completeTurtle[2].setCurrentTileIndex(0);
			break;
		}

		score.setText(scoreText);

		setPosition(camera.getCenterX(), camera.getCenterY());
		scene.attachChild(this);
	}
	
	private class animationListener implements IAnimationListener{

		@Override
		public void onAnimationStarted(AnimatedSprite pAnimatedSprite,
				int pInitialLoopCount) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationFrameChanged(AnimatedSprite pAnimatedSprite,
				int pOldFrameIndex, int pNewFrameIndex) {
			// TODO Auto-generated method stub
			if (pAnimatedSprite == completeTurtle[0]
					&& pAnimatedSprite.getCurrentTileIndex() == 1) {
//				ResourceManager.getInstance().screamSound2.play();
			} else if (pAnimatedSprite == completeTurtle[1]
					&& pAnimatedSprite.getCurrentTileIndex() == 1) {
//				ResourceManager.getInstance().screamSound2.play();
			} else if (pAnimatedSprite == completeTurtle[2]
					&& pAnimatedSprite.getCurrentTileIndex() == 1) {
//				ResourceManager.getInstance().screamSound2.play();
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
}
