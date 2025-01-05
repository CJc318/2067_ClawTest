package frc.robot.commands.Claw;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClawGrab;

public class ClawOpen extends Command {
    private static ClawGrab m_claw;
    
    public ClawOpen() {
        m_claw = ClawGrab.getInstance();
        addRequirements(m_claw);
    }

    @Override public void initialize() {

    }

    @Override public void execute() {
        m_claw.openClaw();
    }

    @Override public void end(boolean interrupted) {

    }

    @Override public boolean isFinished() {
        return true;
    }
}
