package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.commands.lft_enc_cmd;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class lift_enc_subs extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private int low = 0;
  
  private int height_1 = 100;
  private int height_2 = 200;
  private int height_3 = 300;

  public lift_enc_subs() {
  }

  public void translate_request(int input) {
    switch (input) {
      case 0:
        lift_get_height(low);
        break;

      case 1:
        lift_get_height(height_1);
        break;
      
      case 2:
        lift_get_height(height_2);
        break;
      
      case 3:
        lift_get_height(height_3);      
        break;
    }
  }

  private void lift_get_height(int set_to) {
    while (Robot.lift_subsys.lift_master.getSelectedSensorPosition() != set_to) {
      if (Robot.lift_subsys.lift_master.getSelectedSensorPosition() > set_to) {
        Robot.lift_subsys.lift_master.set(ControlMode.PercentOutput, -.5);
      }

      else {
        Robot.lift_subsys.lift_master.set(ControlMode.PercentOutput, .5);
      }
    }
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecsialCommand());
    setDefaultCommand(new lft_enc_cmd());

  }
}
