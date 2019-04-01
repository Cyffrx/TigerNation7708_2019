package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.dt_pneu_cmd;

public class dt_pneu_subs extends Subsystem {

  private DoubleSolenoid left_gear_shift = new DoubleSolenoid(2,3);
  private boolean drivetrain_toggle = false;

  public dt_pneu_subs() {
    //compressor.setClosedLoopControl(true);
  }

  public void toggleGearShift() {
    if (drivetrain_toggle) {
      drivetrain_toggle = !drivetrain_toggle;
      left_gear_shift.set(Value.kForward);
    }
    else {
      drivetrain_toggle = !drivetrain_toggle;
      left_gear_shift.set(Value.kReverse);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new dt_pneu_cmd());
  }
}
