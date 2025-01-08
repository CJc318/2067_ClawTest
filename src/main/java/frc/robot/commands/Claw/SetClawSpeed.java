package frc.robot.commands.Claw;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClawMotor;

public class SetClawSpeed extends Command {
    private ClawMotor m_clawMotor;

    private DoubleSupplier m_clawSpeed;

    public SetClawSpeed(DoubleSupplier clawSpeed) {
        m_clawMotor = ClawMotor.getInstance();  
        addRequirements(m_clawMotor);

        m_clawSpeed = clawSpeed;
    }

    @Override 
    public void initialize() {

    }

    @Override 
    public void execute() {
        m_clawMotor.setSpeed(m_clawSpeed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        m_clawMotor.setSpeed(0.0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}   
