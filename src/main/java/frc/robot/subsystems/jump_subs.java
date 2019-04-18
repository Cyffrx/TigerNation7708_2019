/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.jump_cmd;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * Add your docs here.
 */
public class jump_subs extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private DoubleSolenoid theDumbIdea = new DoubleSolenoid(6,7);
  private DoubleSolenoid rearMistakes = new DoubleSolenoid(5,4);
  
  public jump_subs() {
    theDumbIdea.set(Value.kReverse);
    rearMistakes.set(Value.kReverse);
  }

  public void front_deploy() {
    theDumbIdea.set(Value.kForward);
  }
  public void rear_deploy() {
    rearMistakes.set(Value.kForward);
  }

  public void front_retract() {
    theDumbIdea.set(Value.kReverse);
  }
  public void rear_retract() {
    rearMistakes.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new jump_cmd());
  }
}
