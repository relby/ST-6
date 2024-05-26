package org.example;

import org.junit.Test;
import org.junit.Assert;

public class TicTacToeCellTest {
    private TicTacToeCell cell;

    @Test
    public void testInitialCellState() {
        TicTacToeCell cell = new TicTacToeCell(0, 0, 0);
        Assert.assertEquals(' ', cell.getMarker());
        Assert.assertEquals(0, cell.getNum());
        Assert.assertEquals(0, cell.getRow());
        Assert.assertEquals(0, cell.getCol());
    }
    @Test
    public void testGetRow() {
        TicTacToeCell cell = new TicTacToeCell(0, 0, 0);
        Assert.assertEquals(0, cell.getRow());
    }
    @Test
    public void testGetCol() {
        TicTacToeCell cell = new TicTacToeCell(0, 0, 0);
        Assert.assertEquals(0, cell.getCol());
    }
    @Test
    public void testGetNum() {
        TicTacToeCell cell = new TicTacToeCell(0, 0, 0);
        Assert.assertEquals(0, cell.getNum());
    }
    @Test
    public void testSetMarker() {
        TicTacToeCell cell = new TicTacToeCell(0, 0, 0);
        cell.setMarker("X");
        Assert.assertEquals('X', cell.getMarker());
        Assert.assertFalse(cell.isEnabled());
    }
} 
