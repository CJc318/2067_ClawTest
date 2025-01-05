package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsDevices;
import frc.robot.Constants.dios;

public class ClawGrab extends SubsystemBase {
    private static ClawGrab instance = null;
    private Solenoid m_clawSolenoid = new Solenoid(PneumaticsDevices.MODULE_TYPE, 
    PneumaticsDevices.CLAW_GRAB);

    private final DigitalInput m_gamePieceSensor;

    public static ClawGrab getInstance() {
        if (instance == null) {
            instance = new ClawGrab();
        }
        return instance;
    }

    private ClawGrab() {
        m_gamePieceSensor = new DigitalInput(dios.GAMEPIECE_SENSOR);
    }   

    public void openClaw() {
        m_clawSolenoid.set(true);
    }

    public void closeClaw() {
        m_clawSolenoid.set(false);
    }

    public boolean gamePieceDetected() {
        return !m_gamePieceSensor.get();
    }
}
