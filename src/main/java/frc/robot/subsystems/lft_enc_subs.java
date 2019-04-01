package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class lft_enc_subs extends Subsystem {
  private TalonSRX lift_master = new TalonSRX(RobotMap.lft_lift_master);
  private VictorSPX lift_slave = new VictorSPX(RobotMap.lft_lift_master);
  
  public lft_enc_subs() {
    //lift master encoder set
    lift_master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute); 
    lift_slave.follow(lift_master);
    Robot.lift_subsys.lift_master.setSelectedSensorPosition(0);
  }

  private int defense = 0;
  private int hatch_low = 1;
  private int hatch_mid = 2;
  private int hatch_high= 3;

  public void get_lift_height(int location) {
  // location = 0 // defense
  // location = 1 // low hatch
  // location = 2 // mid hatch
  // location = 3 // high hatch

  int up_or_down = 0;
  int desired_location = 0;
  double lift_speed = .8;

  switch(location) {
    case 0:
      desired_location = defense;
    break;

    case 1:
      desired_location = hatch_low;
    break;
    
    case 2:
      desired_location = hatch_mid;
    break;
    
    case 3:
      desired_location = hatch_high;
    break;
  }

  if (Robot.lift_subsys.lift_master.getSelectedSensorPosition() > desired_location) {
    // go up
    up_or_down = 1;
  }
  else if (Robot.lift_subsys.lift_master.getSelectedSensorPosition() < desired_location) {
    // go down
    up_or_down = -1;
  }

  while (desired_location != Robot.lift_subsys.lift_master.getSelectedSensorPosition() ){
    Robot.lift_subsys.lift_master.set(ControlMode.PercentOutput, lift_speed*up_or_down);

  }
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}