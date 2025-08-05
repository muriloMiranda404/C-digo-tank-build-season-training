package frc.robot.utils;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DriverController extends CommandXboxController{
    
    public DriverController(int Id){
        super(Id);
    }

    public double getMarcha(boolean activate){

        double marcha = 0.5;

        if(activate == true){
            marcha = 0.5 + (super.getHID().getRightTriggerAxis() - super.getHID().getLeftTriggerAxis());
            if(marcha < 0.0){
                marcha = 0.2;
            }
        } else {
            marcha = 0.5;
        }
        return marcha;
    }
}
