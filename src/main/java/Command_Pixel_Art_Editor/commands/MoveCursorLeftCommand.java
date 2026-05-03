package Command_Pixel_Art_Editor.commands;

import Command_Pixel_Art_Editor.model.PixelArtModel;

public class MoveCursorLeftCommand implements Command{
    private PixelArtModel model;

    public MoveCursorLeftCommand(PixelArtModel model) {
        this.model = model;
    }
    @Override
    public void execute() {
        model.moveCursorLeft();
    }
}
