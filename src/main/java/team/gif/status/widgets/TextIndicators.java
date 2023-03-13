package team.gif.status.widgets;

import edu.wpi.first.shuffleboard.api.prefs.Group;
import edu.wpi.first.shuffleboard.api.prefs.Setting;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import team.gif.components.StatusText;
import team.gif.shuffleboard.extensions.RenderedWidget;

import java.util.LinkedList;
import java.util.List;

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
}
