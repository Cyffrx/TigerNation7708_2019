/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.lft_pneu_cmd;

/**
 * Add your docs here.
 */
public class lft_pneu_subs extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private DoubleSolenoid grabber = new DoubleSolenoid(0,1);
  private boolean is_enabled = true;
  
  public lft_pneu_subs() {
    grabber.set(Value.kReverse);
    SmartDashboard.putBoolean("Holding", is_enabled);
  }
  
  public void toggle_grabber() {
    if (is_enabled) {
      grabber.set(Value.kReverse);
      is_enabled = !is_enabled;
    }
    else {
      grabber.set(Value.kForward);
      is_enabled = !is_enabled;
    }
    SmartDashboard.updateValues();
  }
  
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new lft_pneu_cmd());
  }
}
