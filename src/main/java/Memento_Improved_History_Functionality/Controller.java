package Memento_Improved_History_Functionality;


import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoStack;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoStack = new ArrayList<>();

        saveToHistory(); // save initial state at beginning
    }

    public void setOption(int optionNumber, int choice) {
        model.setOption(optionNumber, choice);
        saveToHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        model.setIsSelected(isSelected);
        saveToHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            redoStack.add(model.createMemento()); // save current state to redo
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoStack.clear();
    }

    public void redo(){
        if(!redoStack.isEmpty()){
            history.add(model.createMemento()); //Save current state for undo
            IMemento nextState = redoStack.remove(redoStack.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    // history window controller

    public List<IMemento> getHistory(){
        return history;
    }

    public void restoreFromHistory(IMemento m) {
        saveToHistory();
        model.restoreState(m);
        gui.updateGui();
    }
}
