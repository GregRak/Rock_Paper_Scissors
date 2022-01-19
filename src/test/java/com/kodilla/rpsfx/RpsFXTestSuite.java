package com.kodilla.rpsfx;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RpsFXTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test suite: end");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test case: begin");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test case: end");
    }

    @DisplayName("Method gamePlay with game result: draw")

    @Test
    void gamePlayDrawTest() {
        //Given
        Game game = new Game();
        int playerChoice = 1;
        int computerChoice = 1;
        String expectedResult = "   Draw!!!";
        //When
        String result = game.gamePlay(playerChoice, computerChoice);
        int numberOfRoundsResult = game.getNumberOfRounds();
        int numberOfPlayerWinsResult = game.getNumberOfPlayerWins();
        int numberOfComputerWinsResult = game.getNumberOfComputerWins();
        //Then
        assertEquals(expectedResult, result);
        assertEquals(1, numberOfRoundsResult);
        assertEquals(0, numberOfPlayerWinsResult);
        assertEquals(0, numberOfComputerWinsResult);
    }

    @DisplayName("Method gamePlay with game result: Player win")

    @Test
    void gamePlayPlayerWinTest() {
        //Given
        //Game conditions: 1 - rock, 2 - paper, 3 - scissors
        Game game = new Game();
        int playerChoiceOne = 1; //rock
        int playerChoiceTwo = 2; //paper
        int playerChoiceThree = 3; //scissors
        int computerChoiceOne = 1; //rock
        int computerChoiceTwo = 2; //paper
        int computerChoiceThree = 3; //scissors
        String expectedResult = "  You win!!!";
        String notExpectedResult = " You lose!!!";
        //When
        String resultOne = game.gamePlay(playerChoiceOne, computerChoiceThree);
        String resultTwo = game.gamePlay(playerChoiceTwo, computerChoiceOne);
        String resultThree = game.gamePlay(playerChoiceThree, computerChoiceTwo);
        int numberOfRoundResult = game.getNumberOfRounds();
        int numberOfPlayerWinsResult = game.getNumberOfPlayerWins();
        int numberOfComputerWinsResult = game.getNumberOfComputerWins();
        //Then
        assertEquals(expectedResult, resultOne);
        assertEquals(expectedResult, resultTwo);
        assertEquals(expectedResult, resultThree);
        assertEquals(3, numberOfRoundResult);
        assertEquals(3, numberOfPlayerWinsResult);
        assertEquals(0, numberOfComputerWinsResult);
        assertNotEquals(notExpectedResult, resultOne);
    }

    @DisplayName("Method gamePlay with game result: Computer win")

    @Test
    void gamePlayComputerWinTest() {
        //Given
        //Game conditions: 1 - rock, 2 - paper, 3 - scissors
        Game game = new Game();
        int playerChoiceOne = 1; //rock
        int playerChoiceTwo = 2; //paper
        int playerChoiceThree = 3; //scissors
        int computerChoiceOne = 1; //rock
        int computerChoiceTwo = 2; //paper
        int computerChoiceThree = 3; //scissors
        String expectedResult = " You lose!!!";
        String notExpectedResult = "  You win!!!";
        //When
        String resultOne = game.gamePlay(playerChoiceOne, computerChoiceTwo);
        String resultTwo = game.gamePlay(playerChoiceTwo, computerChoiceThree);
        String resultThree = game.gamePlay(playerChoiceThree, computerChoiceOne);
        int numberOfRoundResult = game.getNumberOfRounds();
        int numberOfPlayerWinsResult = game.getNumberOfPlayerWins();
        int numberOfComputerWinsResult = game.getNumberOfComputerWins();
        //Then
        assertEquals(expectedResult, resultOne);
        assertEquals(expectedResult, resultTwo);
        assertEquals(expectedResult, resultThree);
        assertEquals(3, numberOfRoundResult);
        assertEquals(0, numberOfPlayerWinsResult);
        assertEquals(3, numberOfComputerWinsResult);
        assertNotEquals(notExpectedResult, resultOne);
    }
}
