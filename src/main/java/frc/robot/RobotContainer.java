package frc.robot;

import edu.wpi.first.math.MathUtil;
import frc.robot.Constants.Controllers;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.utils.DriverController;

public class RobotContainer {

  public RobotContainer() {

    TankSubsystem tank = TankSubsystem.getInstance();

    DriverController joystick = new DriverController(Controllers.DRIVE);

    tank.driveTank(
      () -> joystick.getMarcha(true),
      () -> MathUtil.applyDeadband(joystick.getLeftY(), Controllers.DEADBAND),
      () -> MathUtil.applyDeadband(joystick.getRightX(), Controllers.DEADBAND)
      );

    configureDriveBindings();
  }

  
  private void configureDriveBindings() {
    
  }

}
