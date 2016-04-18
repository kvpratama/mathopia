package com.kevinpratama.mathopia;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class SwappableNumber extends Number {

	private float originX = 0;
	private float originY = 0;
	private SwappableNumber[] swappableNumbers;
	private MathSymbol[] mathSymbols;
	private Sprite[] answerHolder;
	private Sprite[] choicesHolder;
	private boolean mGrabbed = false;
	private boolean isSwappable = true;

	public float getOriginX() {
		return originX;
	}

	public float getOriginY() {
		return originY;
	}

	public boolean isSwappable() {
		return isSwappable;
	}

	public void setSwappable(boolean swapable) {
		this.isSwappable = swapable;
	}
	
	public SwappableNumber(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			SwappableNumber[] swapableNumbers, Sprite[] answerHolder,
			Sprite[] choicesHolder) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);

		this.swappableNumbers = swapableNumbers;
		this.mathSymbols = new MathSymbol[0];
		this.answerHolder = answerHolder;
		this.choicesHolder = choicesHolder;
	}

	public SwappableNumber(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			SwappableNumber[] swapableNumbers, Sprite[] answerHolder,
			Sprite[] choicesHolder, int number) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager, number);

		this.swappableNumbers = swapableNumbers;
		this.mathSymbols = new MathSymbol[0];
		this.answerHolder = answerHolder;
		this.choicesHolder = choicesHolder;
	}

	public SwappableNumber(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			SwappableNumber[] swapableNumbers, Sprite[] answerHolder,
			Sprite[] choicesHolder, MathSymbol[] mathSymbols, int number) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager, number);

		this.swappableNumbers = swapableNumbers;
		this.mathSymbols = mathSymbols;
		this.answerHolder = answerHolder;
		this.choicesHolder = choicesHolder;
	}
	
	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			float pTouchAreaLocalX, float pTouchAreaLocalY) {
	
		switch (pSceneTouchEvent.getAction()) {
		case TouchEvent.ACTION_DOWN:
			originX = this.getX();
			originY = this.getY();
			this.setScale(1.2f);
			this.mGrabbed = true;
			break;

		case TouchEvent.ACTION_MOVE:
			if (this.mGrabbed) {
				this.setPosition(pSceneTouchEvent.getX(),
						pSceneTouchEvent.getY());
			}
			break;

		case TouchEvent.ACTION_UP:
			if (this.mGrabbed) {
				this.mGrabbed = false;
				this.setScale(1.0f);
				if (!GameManager.isCollide(this, swappableNumbers, answerHolder,
						choicesHolder, mathSymbols)) {
					this.setPosition(originX, originY);
				} else {
					ResourceManager.getInstance().beepSound.play();
				}
			}
			break;
		}
		return true;
	}
}
