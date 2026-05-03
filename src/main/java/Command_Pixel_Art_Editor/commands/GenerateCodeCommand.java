package Command_Pixel_Art_Editor.commands;

import Command_Pixel_Art_Editor.model.PixelArtModel;

public class GenerateCodeCommand implements Command{
    private PixelArtModel model;

    public GenerateCodeCommand(PixelArtModel model) {
        this.model = model;
    }
    @Override
    public void execute() {
        boolean[][] grid = model.getGrid();

        System.out.println("int[][] pixelArt = {");
        for (int r = 0; r < 8; r++) {
            System.out.print("    {");
            for (int c = 0; c < 8; c++) {
                System.out.print(grid[r][c] ? "1" : "0");
                if (c < 7) System.out.print(", ");
            }
            System.out.println("},");
        }
        System.out.println("};");
    }

}
