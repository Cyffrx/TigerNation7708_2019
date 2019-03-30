/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.jump_cmd;

/**
 * Add your docs here.
 */
public class jump_subs extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Solenoid theDumbIdea = new Solenoid(RobotMap.jp_solenoid);
  private Solenoid theDumbIdeaPt2 = new Solenoid(RobotMap.jp2_solenoid);

  public void kamikaze() {
    theDumbIdea.set(true);
    theDumbIdeaPt2.set(true);
    Timer.delay(.05);
    Timer.delay(.05);
    theDumbIdea.set(false);
    theDumbIdeaPt2.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new jump_cmd());
  }
}
