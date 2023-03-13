package team.gif.status.widgets;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import team.gif.components.StatusText;
import team.gif.shuffleboard.extensions.RenderedWidget;

public class TextIndicator extends RenderedWidget {

    @FXML
    protected Pane pane;

    @FXML
    private StatusText statusText;

    private StatusText.DisplayState lastState = StatusText.DisplayState.LOW;

}
