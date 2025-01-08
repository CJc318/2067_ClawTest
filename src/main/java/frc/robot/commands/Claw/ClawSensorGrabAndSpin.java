package frc.robot.commands.Claw;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.subsystems.ClawGrab;

public class ClawSensorGrabAndSpin extends SequentialCommandGroup {
    public ClawSensorGrabAndSpin() {
        new ParallelCommandGroup(
            new ClawOpen(),
            new SetClawSpeed(() -> 0.5)
        );

        new WaitUntilCommand(() -> ClawGrab.getInstance().gamePieceDetected());
        
        new ParallelCommandGroup(
            new ClawClose(),
            new SetClawSpeed(() -> -0.2)
        );
       
    }
}
