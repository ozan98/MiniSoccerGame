package model;

import java.util.Timer;
import java.util.TimerTask;

import model.players.*;

public class SoccerGame {

	private Integer timeRemaining;

	private Integer goal;

	private Boolean isPaused;

	private Boolean isOver;

	private final PlayerCollection gamePlayers;


	/**
	 * initializes time, SoccerBall, PlayerFactory, and PlayerCollection
	 */
	public SoccerGame() {
		timeRemaining = 60;
		goal = 0;
		isPaused = false;
		isOver = false;
		SoccerBall.getSoccerBall().resetSoccerBall();
		PlayerFactory playerFactory = new PlayerFactory();
		gamePlayers = new PlayerCollection();
		gamePlayers.add(playerFactory.getPlayer("Striker"));
		gamePlayers.add(playerFactory.getPlayer("Goalkeeper"));
		startGame();
	}

	/**
	 * starts the game with timer and timerTask
	 */
	private void startGame() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (!isPaused()) {
					if (getTimeRemaining() <= 0) {
						setOver(true);
						timer.cancel();
					} else {
						setTimeRemaining(getTimeRemaining() - 1);
					}
					if (isScored()) {
						setPaused(true);
						setGoal(getGoal() + 1);
						getActivePlayer().setPlayerStatistics(getActivePlayer().getPlayerStatistics() + 1);
						getGamePlayers().get("Striker").setInitialPosition();
						SoccerBall.getSoccerBall().resetSoccerBall();
					} else {
						automateGoalkeeper();
					}
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	/**
	 * returns time remaining
	 * @return timeReamining
	 */
	public Integer getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * setting the remaining time
	 * @param timeRemaining
	 */
	public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	
	/**
	 * returns the number of goal scored by the striker
	 * @return goal
	 */
	public Integer getGoal() {
		return goal;
	}

	public void setGoal(Integer newGoal) {
		goal = newGoal;
	}
	
	/**
	 * checking whether the game is paused
	 * @return isPaused
	 */
	public Boolean isPaused() {
		return isPaused;
	}

	public void setPaused(Boolean paused) {
		isPaused = paused;
	}
	
	/**
	 * checking whether the game is over
	 * @return isOver
	 */
	public Boolean isOver() {
		return isOver;
	}

	public void setOver(Boolean over) {
		isOver = over;
	}

	public PlayerCollection getGamePlayers() {
		return gamePlayers;
	}

	public void automateGoalkeeper() {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		Goalkeeper goalkeeper = (Goalkeeper) gamePlayers.get("Goalkeeper");
		if (soccerBall.onGoalkeeperSide()) {
			goalkeeper.grabsBall();
			goalkeeper.shootBall();
			goalkeeper.setPlayerStatistics(goalkeeper.getPlayerStatistics() + 1);
		} else {
			goalkeeper.moveRandomly();
		}
	}
	
	/**
	 * checking whether the goal is scored/ the ball is in Gate
	 * @return true if the ball is in the Gate,
	 *         false if the ball is not in the Gate
	 */
	public boolean isScored() {
		return SoccerBall.getSoccerBall().inGate();
	}

	public GamePlayer getActivePlayer() {
		return gamePlayers.get("Striker");
	}
}
