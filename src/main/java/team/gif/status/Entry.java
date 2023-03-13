package team.gif.status;

import com.google.common.collect.ImmutableList;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;
import team.gif.status.widgets.TextIndicators;

import java.util.List;

@Description(group = "Team2338", name = "Swerve Status Plugin", version = "1.0.0", summary = "a way to sample drive motor temperatures")
public class Entry extends Plugin {
    @Override
    @SuppressWarnings("all")
    public List<ComponentType> getComponents() {
        return ImmutableList.of(WidgetType.forAnnotatedWidget(TextIndicators.class));
    }
}
