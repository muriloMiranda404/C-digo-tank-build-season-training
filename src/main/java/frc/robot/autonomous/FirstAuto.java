package frc.robot.autonomous;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.TankSubsystem;

public class FirstAuto {
    
    TankSubsystem tankSubsystem = TankSubsystem.getInstance();
    Timer timer = new Timer();

    public void testeAuto(Double medido, double setpoint, double entrada1, double entrada2){
        if(medido < setpoint){
        tankSubsystem.driveTank(
            () -> entrada1,
            () -> entrada2);            
        } else {
            tankSubsystem.driveTank(
                () -> 0.0,
                () -> 0.0);
        }
        }
}
