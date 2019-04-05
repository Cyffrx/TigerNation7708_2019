package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class lft_manual_cmd extends Command {
  public lft_manual_cmd() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift_subsys);
  }


// Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    /*Robot.lift_subsys.set_lift(
      (Robot.m_oi.lft_gamepad.getTriggerAxis(Hand.kLeft) > 0) ? 
        -Robot.m_oi.lft_gamepad.getTriggerAxis(Hand.kLeft) : Robot.m_oi.lft_gamepad.getTriggerAxis(Hand.kRight),
        Robot.m_oi.lft_gamepad.getBumper(Hand.kLeft)
    );*/

    if (Math.abs(Robot.m_oi.lft_gamepad.getY(Hand.kLeft)) <= .15) {
      Robot.lift_subsys.set_lift(-Robot.m_oi.lft_gamepad.getY(Hand.kRight)*.8);
    } else {
      Robot.lift_subsys.set_lift(-Robot.m_oi.lft_gamepad.getY(Hand.kLeft)*.4);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
