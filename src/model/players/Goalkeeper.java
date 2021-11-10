package model.players;

import model.SoccerBall;

import java.awt.*;
import java.util.Random;

public class Goalkeeper extends GamePlayer {

	private int movementStep;
	
	/**
	 * the constructor to initialize the attributes of the goalkeeper
	 * @param String name, Color color
	 */
	public Goalkeeper(String name, Color color) {
		super(name, color);
		movementStep = 10;
	}
	
	/**
	 * the method that makes the striker move left
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 5 - movementStep > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - movementStep, getPlayerPosition().y));
		}
	}
	/**
	 * the method that makes the striker move right
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 + movementStep < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + movementStep, getPlayerPosition().y));
		}
	}
	
	/**
	 * the method that makes the striker move up
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}
	/**
	 * the method that makes the striker move down
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 300) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}
	
	/**
	 * the method that makes the ball move when the the striker hits the ball
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(-20, -5.0, -0.05);
	}
	
	/**
	 * the method that makes the goalkeeper move randomly in a gaussian distribution fashion
	 */
	public void moveRandomly() {
		Random random = new Random();
		double playerCurrentXPosition = (double) getPlayerPosition().x + 15;
		double chanceOfMovingLeft = (playerCurrentXPosition - 300) / 100 - (random.nextGaussian());
		movementStep = (int) Math.abs(30 * chanceOfMovingLeft);
		if (chanceOfMovingLeft > 0) {
			moveLeft();
		} else {
			moveRight();
		}
	}
	
	/**
	 * sets the goalkeeper's position the default position of the goalkeeper
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(280, 70));
	}
	/**
	 * the method that displays the statistics of the goalkeeper when the game is over
	 */
	@Override
	public String toString() {
		return playerName + " caught " + playerStatistics.toString() + " balls";
	}
}
