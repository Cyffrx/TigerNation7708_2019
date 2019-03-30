package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public XboxController drt_gamepad = new XboxController(RobotMap.drt_gamepad);
  public XboxController lft_gamepad = new XboxController(RobotMap.lft_gamepad);
}
