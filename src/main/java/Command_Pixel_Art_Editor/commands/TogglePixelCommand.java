package Command_Pixel_Art_Editor.commands;

import Command_Pixel_Art_Editor.model.PixelArtModel;

public class TogglePixelCommand implements Command{
    private PixelArtModel model;

    public TogglePixelCommand(PixelArtModel model) {
        this.model = model;
    }
    @Override
    public void execute() {
        model.togglePixel();
    }
}
