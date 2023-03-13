package team.gif.status.widgets;

import edu.wpi.first.shuffleboard.api.prefs.Group;
import edu.wpi.first.shuffleboard.api.prefs.Setting;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import team.gif.components.StatusText;
import team.gif.shuffleboard.extensions.RenderedWidget;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class TextIndicators extends RenderedWidget<Number> {

    @FXML
    protected Pane pane;

    @FXML
    protected StatusText statusText;

    private StatusText.DisplayState lastState = StatusText.DisplayState.NORMAL;

    private SimpleDoubleProperty normalMin = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty normalMax = new SimpleDoubleProperty(0.0);
    private SimpleBooleanProperty normalAnimate = new SimpleBooleanProperty(false);

    private SimpleDoubleProperty warningMin = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty warningMax = new SimpleDoubleProperty(0.0);
    private SimpleBooleanProperty warningAnimate = new SimpleBooleanProperty(false);

    private SimpleDoubleProperty alertMin = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty alertMax = new SimpleDoubleProperty(0.0);
    private SimpleBooleanProperty alertAnimate = new SimpleBooleanProperty(false);

    public Pane getView() {
        return pane;
    }

    public List<Group> getSettings() {
        LinkedList<Group> propertyList = new LinkedList<Group>();

        propertyList.add(Group.of("Definition of Normal",
                Setting.of("Min", "The minimum value in the range of values.", normalMin, Double.class),
                Setting.of("Max", "The maximum value in the range of values.", normalMax, Double.class), Setting.of(
                        "Animate", "Turn on/off animation each time data is received", normalAnimate, Boolean.class)));

        propertyList.add(Group.of("Definition of Warning",
                Setting.of("Min", "The minimum value in the range of values.", warningMin, Double.class),
                Setting.of("Max", "The maximum value in the range of values.", warningMax, Double.class),
                Setting.of("Animate", "Turn on/off animation each time data is received", warningAnimate,
                        Boolean.class)));

        propertyList.add(Group.of("Definition of Alert",
                Setting.of("Min", "The minimum value in the range of values.", alertMin, Double.class),
                Setting.of("Max", "The maximum value in the range of values.", alertMax, Double.class), Setting.of(
                        "Animate", "Turn on/off animation each time data is received", alertAnimate, Boolean.class)));

        return propertyList;
    }

    private void setState(Double forValue) {

        if (forValue >= normalMin.doubleValue() && forValue <= normalMax.doubleValue()) {
            if (normalAnimate.getValue())
                statusText.doAnimateOnData();

            if (lastState == StatusText.DisplayState.NORMAL)
                return;

            lastState = StatusText.DisplayState.NORMAL;
            statusText.displayStateObjectProperty().set(lastState);
            return;
        }

        if (forValue >= warningMin.doubleValue() && forValue <= warningMax.doubleValue()) {
            if (warningAnimate.getValue())
                statusText.doAnimateOnData();

            if (lastState == StatusText.DisplayState.MEDIUM)
                return;

            lastState = StatusText.DisplayState.MEDIUM;
            statusText.displayStateObjectProperty().set(lastState);
            return;
        }

        if (forValue >= alertMin.doubleValue() && forValue <= alertMax.doubleValue()) {
            if (alertAnimate.getValue())
                statusText.doAnimateOnData();

            if (lastState == StatusText.DisplayState.MEDIUM)
                return;

            lastState = StatusText.DisplayState.HIGH;
            statusText.displayStateObjectProperty().set(lastState);
            return;
        }

        if (lastState != StatusText.DisplayState.HIGH) {
            lastState = StatusText.DisplayState.HIGH;
            statusText.displayStateObjectProperty().set(lastState);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.initialize(arg0, arg1);
        statusText.textProperty().bind(titleProperty());

        // Using an anonymous class that implements the ChangeListener<T> interface, every time
        // the bound number changes the value is checked to see if the state (color) needs to be changed.
        dataProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number arg1, Number arg2) {
                setState(arg2.doubleValue());
            }
        });

    }
}
