package team.gif.shuffleboard.extensions;

import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import edu.wpi.first.shuffleboard.app.components.WidgetTile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class RenderedWidget<T> extends SimpleAnnotatedWidget<T> implements Initializable, ChangeListener<Bounds> {
    private WidgetTile tile = null;

    @Override
    public void changed(ObservableValue<? extends Bounds> arg0, Bounds oldValue, Bounds newValue) {
        if (tile == null) {
            Parent p = getView().getParent();

            while (p != null) {
                p = p.getParent();

                if (p != null && p.getClass() == WidgetTile.class) {
                    tile = (WidgetTile) p;

                    Tooltip titleTip = new Tooltip();
                    titleTip.textProperty().bind(titleProperty());
                    Tooltip.install(tile, titleTip);

                    ObservableList<Node> c = tile.getChildren();
                    c.remove(0);

                    break;
                }
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Pane p = getView();
        if (p != null) {
            p.layoutBoundsProperty().addListener(this);
        }
    }
}
