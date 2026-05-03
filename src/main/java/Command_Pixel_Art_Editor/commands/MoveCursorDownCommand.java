package Command_Pixel_Art_Editor.commands;

import Command_Pixel_Art_Editor.model.PixelArtModel;

public class MoveCursorDownCommand implements Command{
    private PixelArtModel model;

    public MoveCursorDownCommand(PixelArtModel model) {
        this.model = model;
    }
    @Override
    public void execute() {
        model.moveCursorDown();
    }
}
