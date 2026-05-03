package Command_Pixel_Art_Editor.ui;

import Command_Pixel_Art_Editor.commands.*;
import Command_Pixel_Art_Editor.model.PixelArtModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PixelArtEditor extends Application {

    private PixelArtModel model = new PixelArtModel();
    private Rectangle[][] cells = new Rectangle[8][8];

    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Rectangle rect = new Rectangle(40, 40, Color.WHITE);
                rect.setStroke(Color.GRAY);
                cells[r][c] = rect;
                gridPane.add(rect, c, r);
            }
        }

        Button generateButton = new Button("Create Code");
        generateButton.setFocusTraversable(false);
        generateButton.setOnAction(e -> new GenerateCodeCommand(model).execute());

        VBox root = new VBox(gridPane, generateButton);
        Scene scene = new Scene(root);

        // KEYBOARD HANDLING
        scene.setOnKeyPressed(e -> {
            Command cmd = null;

            if (e.getCode() == KeyCode.UP) cmd = new MoveCursorUpCommand(model);
            if (e.getCode() == KeyCode.DOWN) cmd = new MoveCursorDownCommand(model);
            if (e.getCode() == KeyCode.LEFT) cmd = new MoveCursorLeftCommand(model);
            if (e.getCode() == KeyCode.RIGHT) cmd = new MoveCursorRightCommand(model);
            if (e.getCode() == KeyCode.SPACE) cmd = new TogglePixelCommand(model);

            if (cmd != null) {
                cmd.execute();
                refreshGrid();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();

        //Ensure keyboard focus
        gridPane.requestFocus();
        scene.setOnMouseClicked(e -> gridPane.requestFocus());

        refreshGrid();
    }

    private void refreshGrid() {
        boolean[][] grid = model.getGrid();

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {

                cells[r][c].setFill(grid[r][c] ? Color.BLACK : Color.WHITE);

                if (r == model.getCursorRow() && c == model.getCursorCol()) {
                    cells[r][c].setStroke(Color.RED);
                } else {
                    cells[r][c].setStroke(Color.GRAY);
                }
            }
        }
    }
}
