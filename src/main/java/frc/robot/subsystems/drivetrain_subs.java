package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.drivetrain_cmd;

public class drivetrain_subs extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX right_master = new WPI_TalonSRX(RobotMap.dt_right_master);
  public VictorSPX right_slave_1 = new VictorSPX(RobotMap.dt_right_slave_1);
  public VictorSPX right_slave_2 = new VictorSPX(RobotMap.dt_right_slave_2);
  //private VictorSPX right_slave_3 = new VictorSPX(RobotMap.dt_right_slave_3); // direction needs to be configured -- probably same as master

  public WPI_TalonSRX left_master = new WPI_TalonSRX(RobotMap.dt_left_master);
  public VictorSPX left_slave_1 = new VictorSPX(RobotMap.dt_left_slave_1);
  public VictorSPX left_slave_2 = new VictorSPX(RobotMap.dt_left_slave_2);
  //private VictorSPX left_slave_3 = new VictorSPX(RobotMap.dt_left_slave_3); // direction needs to be configured -- probably same as master

  //public DifferentialDrive drive = new DifferentialDrive(left_master, right_master);
  public DifferentialDrive drive = new DifferentialDrive(left_master, right_master);
  private double turn_limiter = .70;
  
  public drivetrain_subs() {

    right_master.setInverted(false);
    right_slave_1.setInverted(true);
    right_slave_2.setInverted(true);
 
    right_slave_1.follow(right_master);
    right_slave_2.follow(right_master);

    left_master.setInverted(false);
    left_slave_1.setInverted(true);
    left_slave_2.setInverted(true);

    left_slave_1.follow(left_master);
    left_slave_2.follow(left_master);
  }
  
  public void cheezy_scheme(double move, double turn) {

    drive.curvatureDrive(
      move,
      turn*=-turn_limiter,
      true
    );
  }

  public void debug_dt_voltages() {
    /*
    SmartDashboard.putNumber("DT:right Master", right_master.getMotorOutputVoltage());
    SmartDashboard.putNumber("DT:right Slave 1", right_master.getMotorOutputVoltage());
    SmartDashboard.putNumber("DT:right Slave 2", right_master.getMotorOutputVoltage());

    SmartDashboard.putNumber("DT:left Master", left_master.getMotorOutputVoltage());
    SmartDashboard.putNumber("DT:left Slave 1", left_master.getMotorOutputVoltage());
    SmartDashboard.putNumber("DT:left Slave 2", left_master.getMotorOutputVoltage());
    */
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new drivetrain_cmd());
  }
}
