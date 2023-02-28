package team.gif.components;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @author greenden007
 * @since 2/28/23
 */
public class ModuleMotorTemp extends ComplexData<ModuleMotorTemp> {
    double turnMotorTemp;
    double driveMotorTemp;

    /**
     * Constructs a Module Motor Temperature tracker
     * @param turnMotorTemp the turn motor temperature
     * @param driveMotorTemp the drive motor temperature
     */
    public ModuleMotorTemp(Supplier<Double> turnMotorTemp, Supplier<Double> driveMotorTemp) {
        this.turnMotorTemp = turnMotorTemp.get();
        this.driveMotorTemp = driveMotorTemp.get();
    }

    public Map<String, Object> asMap() {
        return Map.of("turn motor temp", turnMotorTemp, "drive motor temp", driveMotorTemp);
    }
}
