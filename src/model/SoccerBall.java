package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SoccerBall {

	private static final SoccerBall soccerBall = new SoccerBall();

	private Point position;

	private double velocity;

	private final Color color;
	/**
	 * the constructor to initialize the soccerball
	 */
	private SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}
	
	/**
	* returning static the soccerBall object
	* @return soccerBall
	*/
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}
	
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}
	
	/**
	* resetting velocity and position of the ball 
	*/
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}
	/**
	* checks whether ball is on goalkeeper side
	* @return true, if the ball is on goalkeeper side
	*	  false, if the ball is not on goalkeeper side
	*/
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}
	/**
	* checks whether ball is in Gate
	* @return true, if the ball is in Gate
	*	  false, if the ball is not in Gate
	*/
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}
	/**
	* sets the velocity of ball object 
	* @param double velocity
	*/
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
	/**
	* getting the position of the ball, returning the position of the ball
	* @return position
	*/
	public Point getPosition() {
		return position;
	}
	
	/**
	* sets the position of ball object 
	* @param Point position
	*/
	public void setPosition(Point position) {
		this.position = position;
	}
	
	/**
	* getting the color of the ball, returning the color of the ball
	* @return color
	*/
	public Color getColor() {
		return color;
	}
}
