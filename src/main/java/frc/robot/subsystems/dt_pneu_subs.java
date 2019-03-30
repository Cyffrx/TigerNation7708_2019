package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.dt_pneu_cmd;

public class dt_pneu_subs extends Subsystem {

  private Solenoid left_gear_shift = new Solenoid(RobotMap.dt_solenoid);
  private Solenoid right_gear_shift = new Solenoid(RobotMap.dt_solenoid);

  private Compressor compressor = new Compressor(0); // default pcm id

  public dt_pneu_subs() {
    compressor.setClosedLoopControl(true);
  }

  public void toggleGearShift() {
    left_gear_shift.set(!left_gear_shift.get());
    right_gear_shift.set(!right_gear_shift.get());
  }

  public void toggle_compressor() {
    if (compressor.enabled()) {
      compressor.stop();
    } 
    else {
      compressor.start();
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new dt_pneu_cmd());
  }
}
