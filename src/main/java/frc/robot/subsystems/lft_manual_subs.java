package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.lft_manual_cmd;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */

public class lft_manual_subs extends Subsystem {
  public TalonSRX lift_master = new TalonSRX(RobotMap.lft_lift_master);
  public VictorSPX lift_slave = new VictorSPX(RobotMap.lft_lift_master);

  public lft_manual_subs() {  
    lift_master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    lift_slave.follow(lift_master);
  }

  public void set_lift(double speed) {
    lift_master.set(ControlMode.PercentOutput, speed);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new lft_manual_cmd());
  }
}
