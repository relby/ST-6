package org.example;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;

public class GameTest {
    @Test
    public void testCheckStateOWIN() {
        Game game = new Game();
        char[] board = { 'X', 'O', 'X', ' ', 'O', 'X', ' ', 'O', ' ' };
        game.symbol = 'O';
        Assert.assertEquals(game.checkState(board), State.OWIN);
    }
    @Test
    public void testCheckStateXWIN() {
        Game game = new Game();
        char[] board = { 'X', 'O', 'X', 'O', 'X', 'O', 'X', ' ', ' ' };
        game.symbol = 'X';
        Assert.assertEquals(game.checkState(board), State.XWIN);
    }
    @Test
    public void testCheckStatePLAYING() {
        Game game = new Game();
        char[] board = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        Assert.assertEquals(game.checkState(board), State.PLAYING);
    }
    @Test
    public void testCheckStateDRAW() {
        Game game = new Game();
        char[] board = { 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X' };
        Assert.assertEquals(game.checkState(board), State.DRAW);
    }
    @Test
    public void testInitialGameState() {
        Game game = new Game();
        Assert.assertEquals(game.state, State.PLAYING);
        Assert.assertEquals(game.player1.symbol, 'X');
        Assert.assertEquals(game.player2.symbol, 'O');
        Assert.assertEquals(game.board.length, 9);
	for (int i = 0; i < game.board.length; i++) {
            Assert.assertEquals(game.board[i], ' ');
	}
    }
    @Test
    public void testGenerateMovesEmptyArray() {
        Game game = new Game();
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(game.board, moves);
        Assert.assertEquals(9, moves.size());
    }

    @Test
    public void testGenerateMovesOneCol() {
        Game game = new Game();
        game.board[0] = 'X';
        game.board[4] = 'X';
        game.board[7] = 'X';
        ArrayList<Integer> moves = new ArrayList<>();
        game.generateMoves(game.board, moves);
        Assert.assertEquals(6, moves.size());
    }

    @Test
    public void testEvaluatePositionPlaying() {
        Game game = new Game();
        int result = game.evaluatePosition(game.board, game.player1);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testEvaluatePosition() {
        Game game = new Game();
        game.symbol = 'X';
        game.board = new char[] {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O'};
        int result = game.evaluatePosition(game.board, game.player1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testEvaluatePositionPlayer1Lose() {
        Game game = new Game();
        game.symbol = 'O';
        game.board[0] = game.player2.symbol;
        game.board[1] = game.player2.symbol;
        game.board[2] = game.player2.symbol;
        int result = game.evaluatePosition(game.board, game.player1);
        Assert.assertEquals(-Game.INF, result);
    }

    @Test
    public void testEvaluatePositionPlayer1Win() {
        Game game = new Game();
        game.symbol = 'X';
        game.board[0] = game.player1.symbol;
        game.board[1] = game.player1.symbol;
        game.board[2] = game.player1.symbol;
        int result = game.evaluatePosition(game.board, game.player1);
        Assert.assertEquals(+Game.INF, result);
    }

    @Test
    public void testMiniMax() {
        Game game = new Game();
        game.board = new char[] {'X', 'X', ' ', ' ', 'O', 'X', ' ', ' ', 'X'};
        int move = game.MiniMax(game.board, game.player2);
        Assert.assertTrue(move >= 1 && move <= 9);
    }
}
