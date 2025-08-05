package frc.robot.subsystems;

import java.util.function.DoubleSupplier;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class TankSubsystem extends SubsystemBase{

    DoubleSupplier firstInput;
    DoubleSupplier secondInput;

    SparkMax rightLead;
    SparkMax rightFollow;
    SparkMax leftLead;
    SparkMax leftFollow;

    DifferentialDrive drive;

    SparkMaxConfig right_follow_config;
    SparkMaxConfig right_lead_config;
    SparkMaxConfig left_follow_config;
    SparkMaxConfig left_lead_config;
    SparkMaxConfig global_config;

    public TankSubsystem(){
        
        rightLead = new SparkMax(DriveConstants.RIGHT_LEAD, SparkMax.MotorType.kBrushed);
        rightFollow = new SparkMax(DriveConstants.RIGHT_FOLLOW, SparkMax.MotorType.kBrushed);
        leftFollow = new SparkMax(DriveConstants.LEFT_FOLLOW, SparkMax.MotorType.kBrushed);
        leftLead = new SparkMax(DriveConstants.LEFT_LEAD, SparkMax.MotorType.kBrushed);

        drive = new DifferentialDrive(leftLead, rightLead);

        global_config = new SparkMaxConfig();
        right_follow_config = new SparkMaxConfig();
        right_lead_config = new SparkMaxConfig();
        left_follow_config = new SparkMaxConfig();
        left_lead_config = new SparkMaxConfig();

        global_config
        .idleMode(IdleMode.kBrake);

        left_lead_config
        .inverted(false)
        .apply(global_config);

        left_follow_config
        .inverted(true)
        .apply(global_config)
        .follow(leftLead);

        right_lead_config
        .apply(global_config)
        .inverted(true);

        right_follow_config
        .apply(global_config)
        .inverted(false)
        .follow(rightLead);

        rightLead.configure(right_lead_config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        rightFollow.configure(right_follow_config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        leftLead.configure(left_lead_config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        leftFollow.configure(left_follow_config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);

    }

    @Override
    public void periodic(){

    }

    public void driveTank(DoubleSupplier multiplicator, DoubleSupplier firstInput, DoubleSupplier secondInput){

        try{

        double inverter = DriverStation.getAlliance().get() == Alliance.Red ? -1.0 : 1.0;

        double speed = firstInput.getAsDouble() * inverter * multiplicator.getAsDouble();
        double rotation = secondInput.getAsDouble() * -1.0 * multiplicator.getAsDouble();

        drive.arcadeDrive(speed, rotation);


    } catch(Exception e ){
        System.out.println("erro o inicializar o drive do tank: " + e.getMessage());
    }
}
}