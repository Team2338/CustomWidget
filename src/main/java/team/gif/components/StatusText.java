package team.gif.components;

import animatefx.animation.Pulse;
import animatefx.animation.Wobble;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatusText extends VBox implements Initializable, ChangeListener<StatusText.DisplayState> {
    public enum DisplayState {
        NORMAL, LOW, MEDIUM, HIGH
    }

    @FXML
    private Label textContent;
    private Pulse pulse;
    private Wobble wobble;

    private ObjectProperty<DisplayState> stateProperty = new SimpleObjectProperty<>(DisplayState.LOW);

    public StatusText() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StatusText.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public StringProperty textProperty() {
        return textContent.textProperty();
    }

    public ObjectProperty<Paint> textColorProperty() {
        return textContent.textFillProperty();
    }

    public ObjectProperty<DisplayState> displayStateObjectProperty() {
        return stateProperty;
    }

    public void doAnimateOnData() {
        wobble.play();
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String text) {
        textProperty().set(text);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        stateProperty.addListener(this);
        stateProperty.setValue(DisplayState.LOW);

        pulse = new Pulse(textContent);
        wobble = new Wobble(textContent);
    }

    @Override
    public void changed(ObservableValue<? extends DisplayState> arg0, DisplayState arg1, DisplayState arg2) {
        textContent.getStyleClass().clear();
        textContent.getStyleClass().add(arg2.toString().toLowerCase());
        pulse.play();
    }
}
