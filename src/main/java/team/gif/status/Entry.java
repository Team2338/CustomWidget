package team.gif.status;

import com.google.common.collect.ImmutableList;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;
import edu.wpi.first.shuffleboard.plugin.base.widget.TextViewWidget;

import java.util.List;

@Description(group = "2338 GIF", name = "Swerve Status", summary = "Plugin for indicating temperature status on a swerve drive", version = "1.0.0")
public class Entry extends Plugin {
    @Override
    @SuppressWarnings("all")
    public List<ComponentType> getComponents() {
        return ImmutableList.of(WidgetType.forAnnotatedWidget(TextViewWidget.class));
    }
}
