package frc.robot.utils;

import java.util.HashMap;

public interface ButtonMap {

    HashMap<NormalButtons, Integer> NormalButtonMap();
    HashMap<Axis, Integer> AxisMap();
    HashMap<AnotherButtons, Integer> AnotherButton();

    public enum NormalButtons{
        A_BUTTON,
        B_BUTTON,
        Y_BUTTON,
        X_BUTTON,
        RIGHT_BUMPER,
        LEFT_BUMPER,
    }

    public enum Axis{
        LEFT_TRIGGER,
        RIGHT_TRIGGER;
    }

    public enum AnotherButtons{
        BACK_RIGHT_BUTTON,
        BACK_LEFT_BUTTON,
        START_BUTTON,
        PRINT_BUTTON;
    }
}
