package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.dt_pneu_cmd;

public class dt_pneu_subs extends Subsystem {

  private DoubleSolenoid rearGearShift = new DoubleSolenoid(2,3);
  private boolean drivetrain_toggle = false;

  public dt_pneu_subs() {
    rearGearShift.set(Value.kReverse);
    //compressor.setClosedLoopControl(true);
  }

  public void toggleGearShift() {
    if (drivetrain_toggle) {
      drivetrain_toggle = !drivetrain_toggle;
      rearGearShift.set(Value.kForward);
    }
    else {
      drivetrain_toggle = !drivetrain_toggle;
      rearGearShift.set(Value.kReverse);
    }
    SmartDashboard.putBoolean("i am speed", drivetrain_toggle);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new dt_pneu_cmd());
  }
}
