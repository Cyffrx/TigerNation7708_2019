package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.dt_pneu_cmd;

public class dt_pneu_subs extends Subsystem {

  private DoubleSolenoid rearGearShift = new DoubleSolenoid(2,3);
  private boolean low_gear = false; // false == high gear

  public dt_pneu_subs() {
    rearGearShift.set(Value.kReverse);
    low_gear = false;
    update_gear();
    //compressor.setClosedLoopControl(true);
  }

  public void gear_override_low() {
    rearGearShift.set(Value.kForward);
  }

  public void gear_override_high() {
    rearGearShift.set(Value.kReverse);
  }

  private void update_gear() {
    if (low_gear) {
      rearGearShift.set(Value.kForward);
    } else {
      rearGearShift.set(Value.kReverse);
    }
    SmartDashboard.putBoolean("High Speed", !low_gear);
    SmartDashboard.putBoolean("High Push", low_gear);
  }

  public void toggleGear() {
    if (low_gear) {
      low_gear = false;
    }
    else {
      low_gear = true;
    }
    update_gear();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new dt_pneu_cmd());
  }
}
