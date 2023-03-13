package team.gif.status;

import com.google.common.collect.ImmutableList;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;
<<<<<<< HEAD
import team.gif.status.widgets.TextIndicators;

import java.util.List;

@Description(group = "Team2338", name = "Swerve Status Plugin", version = "1.0.0", summary = "a way to sample drive motor temperatures")
=======
import edu.wpi.first.shuffleboard.plugin.base.widget.TextViewWidget;

import java.util.List;

@Description(group = "2338 GIF", name = "Swerve Status", summary = "Plugin for indicating temperature status on a swerve drive", version = "1.0.0")
>>>>>>> origin/main
public class Entry extends Plugin {
    @Override
    @SuppressWarnings("all")
    public List<ComponentType> getComponents() {
<<<<<<< HEAD
        return ImmutableList.of(WidgetType.forAnnotatedWidget(TextIndicators.class));
=======
        return ImmutableList.of(WidgetType.forAnnotatedWidget(TextViewWidget.class));
>>>>>>> origin/main
    }
}
