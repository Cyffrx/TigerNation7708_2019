package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class lft_enc_cmd extends Command {
  public lft_enc_cmd() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  
    requires (Robot.lft_encoder);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.m_oi.lft_gamepad.getAButtonPressed()) {
      Robot.lft_encoder.translate_request(0);
    }
    
    else if (Robot.m_oi.lft_gamepad.getXButtonPressed()) {
      Robot.lft_encoder.translate_request(1);
    }

    else if (Robot.m_oi.lft_gamepad.getYButtonPressed()) {
      Robot.lft_encoder.translate_request(2);
    }

    else if (Robot.m_oi.lft_gamepad.getBButtonPressed()) {
      Robot.lft_encoder.translate_request(3);
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
