package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class dt_pneu_cmd extends Command {
  public dt_pneu_cmd() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.dt_pneu);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.m_oi.drt_gamepad.getBumperPressed(Hand.kLeft)) {
      Robot.dt_pneu.toggleGear();
    }
    if (Robot.m_oi.lft_gamepad.getAButtonPressed()) {
      Robot.dt_pneu.gear_override_low();
    }
    else if (Robot.m_oi.lft_gamepad.getBButtonPressed()) {
      Robot.dt_pneu.gear_override_high();
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
