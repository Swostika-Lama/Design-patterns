package Command_Pixel_Art_Editor.commands;

import Command_Pixel_Art_Editor.model.PixelArtModel;

public class MoveCursorUpCommand implements Command {
    private PixelArtModel model;
    public MoveCursorUpCommand(PixelArtModel model) {
        this.model = model;
    }
    @Override
    public void execute() {
        model.moveCursorUp();
    }
}
