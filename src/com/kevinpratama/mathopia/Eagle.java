package com.kevinpratama.mathopia;

import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class Eagle extends AnimatedSprite implements AnimationListener {

	private AnimatedSprite targetTurtle;
	private Eagle nextEagle;
	private MoveXModifier moveX;
	private int moveSpeed;
	public Eagle getNextEagle() {
		return nextEagle;
	}

	public void setNextEagle(Eagle nextEagle) {
		this.nextEagle = nextEagle;
	}

//	private boolean isLastEagle = false;
	
	public Eagle(float pX, float pY, ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			AnimatedSprite targetTurtle, int moveSpeed) {
		
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);
		
		this.targetTurtle = targetTurtle;
//		this.nextEagle = nextEagle;
		this.moveSpeed = moveSpeed;
//		this.isLastEagle = isLastEagle;
	}
	
	public Eagle(float pX, float pY, ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			AnimatedSprite targetTurtle, int moveSpeed, boolean isLastEagle) {
		
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);
		
		this.targetTurtle = targetTurtle;
//		this.nextEagle = nextEagle;
		this.moveSpeed = moveSpeed;
//		this.isLastEagle = isLastEagle;
	}
	
	public void startMove(){
		moveX = new MoveXModifier(moveSpeed, this.getX(), targetTurtle.getX());
		final long[] EAGLE_ANIMATE = new long[] { 5000, 500 };
		
		this.registerEntityModifier(moveX);
		this.animate(EAGLE_ANIMATE);
	}

	@Override
	protected void onManagedUpdate(float pSecondsElapsed) {
		// TODO Auto-generated method stub
		super.onManagedUpdate(pSecondsElapsed);
		
//		if (this.collidesWith(targetTurtle)) {
//			this.setVisible(false);
//			this.setPosition(-200, -200);
//			
//			this.unregisterEntityModifier(moveX);
//			this.stopAnimation();
//		
//			this.detachSelf();
//			
//			if (!isLastEagle) {
//				nextEagle.startMove();
//			}
//		}

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

}
