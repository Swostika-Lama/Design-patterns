package Command_Pixel_Art_Editor.model;


public class PixelArtModel {

    private final int SIZE = 8;
    private boolean[][] grid = new boolean[SIZE][SIZE];
    private int cursorRow = 0;
    private int cursorCol = 0;

    public int getSize() {
        return SIZE;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    public void moveCursorUp() {
        if (cursorRow > 0) cursorRow--;
    }

    public void moveCursorDown() {
        if (cursorRow < SIZE - 1) cursorRow++;
    }

    public void moveCursorLeft() {
        if (cursorCol > 0) cursorCol--;
    }

    public void moveCursorRight() {
        if (cursorCol < SIZE - 1) cursorCol++;
    }

    public void togglePixel() {
        grid[cursorRow][cursorCol] = !grid[cursorRow][cursorCol];
    }
}

