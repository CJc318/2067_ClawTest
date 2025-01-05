package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsDevices;

public class ClawGrab extends SubsystemBase {
    private static ClawGrab instance = null;
    private Solenoid m_clawSolenoid = new Solenoid(PneumaticsDevices.MODULE_TYPE, 
    PneumaticsDevices.CLAW_GRAB);

    public static ClawGrab getInstance() {
        if (instance == null) {
            instance = new ClawGrab();
        }
        return instance;
    }

    public void openClaw() {
        m_clawSolenoid.set(true);
    }

    public void closeClaw() {
        m_clawSolenoid.set(false);
    }
}
