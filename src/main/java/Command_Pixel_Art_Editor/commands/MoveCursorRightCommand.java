package Command_Pixel_Art_Editor.commands;

import Command_Pixel_Art_Editor.model.PixelArtModel;

public class MoveCursorRightCommand implements Command{
    private PixelArtModel model;

    public MoveCursorRightCommand(PixelArtModel model) {
        this.model = model;
    }
    @Override
    public void execute() {
        model.moveCursorRight();
    }
}
