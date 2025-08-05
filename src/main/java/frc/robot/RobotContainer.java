// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.Controllers;
import frc.robot.subsystems.TankSubsystem;
import frc.robot.utils.DriverController;

public class RobotContainer {

  public RobotContainer() {

    TankSubsystem tank = new TankSubsystem();

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
