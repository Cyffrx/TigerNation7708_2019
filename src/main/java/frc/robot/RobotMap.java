package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static final int dt_right_master = 2;
  public static final int dt_right_slave_1 = 1;
  public static final int dt_right_slave_2 = 3;
  //public static final int dt_right_slave_3;

  public static final int dt_left_master = 2;
  public static final int dt_left_slave_1 = 1;
  public static final int dt_left_slave_2 = 3;
  //public static final int dt_left_slave_3;
  
  public static final int lft_lift_master = 8;
  public static final int lft_lift_slave = 7;

  public static final int drt_gamepad = 0;
  public static final int lft_gamepad = 1;

  public static final int dt_solenoid = 1;
  public static final int lft_solenoid_grab = 2;
  public static final int jp_solenoid = 3;
  public static final int jp2_solenoid = 4;

}
