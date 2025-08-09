package frc.robot.utils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class DriverController extends CommandXboxController{

    private ButtonMap map;
    
    public DriverController(int Id, ButtonMap map){
        super(Id);
        this.map = map;
    }

    public JoystickButton getButton(ButtonMap.NormalButtons button){
        return new JoystickButton((GenericHID) this.map, map.NormalButtonMap().get(button));
    }

    public JoystickButton getAxis(ButtonMap.Axis axis){
        return new JoystickButton((GenericHID) this.map, map.AxisMap().get(axis));
    }

    public JoystickButton getAnotherButton(ButtonMap.AnotherButtons anotherButtons){
        return new JoystickButton((GenericHID) this.map, map.AnotherButton().get(anotherButtons));
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

    public void getButton(){

    }
}
