package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawMotor extends SubsystemBase {
    private static ClawMotor instance = null;

    private static TalonSRX m_motor;
    private static DigitalInput m_gamePieceSensor;

    //add current limit configs here (Current lower time and current lower limit are optional? will look into this futher on docs)
    // private static final CurrentLimitsConfigs CURRENT_LIMITS_CONFIGS = new CurrentLimitsConfigs()
    //     .withSupplyCurrentLimit(0)
    //     .withSupplyCurrentLowerTime(0)
    //     .withSupplyCurrentLowerLimit(0);

    public static ClawMotor getInstance() {
        if (instance == null) {
            instance = new ClawMotor();
        }
        return instance;
    }   

    private ClawMotor() {
        m_motor = new TalonSRX(10);
        
        //current limit configs according to SRX documentation??? (will look into this further) cleanup later!!!
        m_motor.configPeakCurrentLimit(30);
        m_motor.configPeakCurrentDuration(200);
        m_motor.configContinuousCurrentLimit(20);
        m_motor.enableCurrentLimit(true);
        
        m_motor.setNeutralMode(NeutralMode.Coast);
        
        m_gamePieceSensor = new DigitalInput(0);
    }

    public void setSpeed(double speed) {
        m_motor.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public boolean gamePieceDetected() {
        return !m_gamePieceSensor.get(); 
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

}
