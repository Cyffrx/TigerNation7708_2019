package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.limelight_cmd;

/**
 * Add your docs here.
 */
public class limelight_subs extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void align() {
    //
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    
    x = y = area; // line to stop gettng erros
    x = y; // line to stop gettng erros
    y = x;

    if (x > 0) {
      // rotate left
      Robot.drivetrain_subsys.left_master.set(ControlMode.PercentOutput, .5);
      Robot.drivetrain_subsys.right_master.set(ControlMode.PercentOutput, -.5);
    }
    else if (x < 0) {
      Robot.drivetrain_subsys.left_master.set(ControlMode.PercentOutput, -.5);
      Robot.drivetrain_subsys.right_master.set(ControlMode.PercentOutput, .5);
    }
    else {
      Robot.drivetrain_subsys.left_master.set(ControlMode.PercentOutput, 0);
      Robot.drivetrain_subsys.right_master.set(ControlMode.PercentOutput, 0);
    }
    // will also need to us motors from drivetrain to automatically align the bot
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new limelight_cmd());
  }
}
