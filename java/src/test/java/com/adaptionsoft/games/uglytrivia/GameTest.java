package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
  @Test
  public void canAddPlayers() {
    Game aGame = new Game();
    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");
    assertEquals(aGame.howManyPlayers(), 3);
  }

  @Test
  public void canGetCurrentPlayer() {
    Game aGame = new Game();
    aGame.add("Chet");
    aGame.add("Pat");
    assertEquals(aGame.getCurrentPlayer(), "Chet");
  }

  @Test
  public void currentPlayerRotatesAfterCorrectAnswers() {
    Game aGame = new Game();
    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");
    assertEquals(aGame.getCurrentPlayer(), "Chet");

    aGame.roll(1);
    aGame.wasCorrectlyAnswered();

    assertEquals(aGame.getCurrentPlayer(), "Pat");

    aGame.roll(1);
    aGame.wasCorrectlyAnswered();

    assertEquals(aGame.getCurrentPlayer(), "Sue");

    aGame.roll(1);
    aGame.wasCorrectlyAnswered();

    assertEquals(aGame.getCurrentPlayer(), "Chet");
  }

  @Test
  public void currentPlayerRotatesAfterIncorrectAnswers() {
    Game aGame = new Game();
    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");
    assertEquals(aGame.getCurrentPlayer(), "Chet");

    aGame.roll(1);
    aGame.wrongAnswer();

    assertEquals(aGame.getCurrentPlayer(), "Pat");

    aGame.roll(1);
    aGame.wrongAnswer();

    assertEquals(aGame.getCurrentPlayer(), "Sue");

    aGame.roll(1);
    aGame.wrongAnswer();

    assertEquals(aGame.getCurrentPlayer(), "Chet");
  }
}
