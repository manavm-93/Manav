package frc.robot.subsystems;

import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WheelSubsystem extends SubsystemBase{
    
    private final TalonFX wheelMotor = new TalonFX(50);
    private final VelocityVoltage request = new VelocityVoltage(0);
    public WheelSubsystem()
    {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.CurrentLimits.SupplyCurrentLimitEnable = true;
        config.CurrentLimits.StatorCurrentLimit = 80;
        config.CurrentLimits.SupplyCurrentLimit = 60;
        config.Feedback.SensorToMechanismRatio =    Constants.SPINDEXER_GEAR_RATIO;

        config.Slot0.kG = 0;
        config.Slot0.kA = 0; 
        config.Slot0.kV = 0; 
        config.Slot0.kS = 0; 
        wheelMotor.getConfigurator().apply(config);
        
    }

    public void goToVelocity(double RotationsPerSecond)
    {
        wheelMotor.setControl(
            request.withVelocity(RotationsPerSecond));
    }
}
