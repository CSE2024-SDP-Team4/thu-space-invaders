package screen;

import java.awt.event.KeyEvent;
import java.awt.*;
import engine.Cooldown;
import engine.Core;
import engine.Sound;


/**
 * Implements the HUD setting screen, it shows setting menu about HUD.
 */

public class LevelScreen extends Screen {

    /**
     * Milliseconds between changes in user selection.
     */
    private static final int SELECTION_TIME = 200;
    /**
     * Time between changes in user selection.
     */
    private Cooldown selectionCooldown;
    /**
     * Constructor, establishes the properties of the screen.
     *
     * @param width  Screen width.
     * @param height Screen height.
     * @param fps    Frames per second, frame rate at which the game is run.
     */
    public LevelScreen(final int width, final int height, final int fps) {
        super(width, height, fps);

        this.returnCode = 400080;
        this.selectionCooldown = Core.getCooldown(SELECTION_TIME);
        this.selectionCooldown.reset();
    }

    /**
     * Starts the action.
     *
     * @return Next screen code.
     */
    public final int run() {
        super.run();

        return this.returnCode;
    }

    /**
     * Updates the elements on screen and checks for events.
     */
    protected final void update() {
        super.update();

        draw();
        if (this.selectionCooldown.checkFinished()
                && this.inputDelay.checkFinished()) {
            if (inputManager.isKeyDown(KeyEvent.VK_UP)
                    || inputManager.isKeyDown(KeyEvent.VK_W)) {
                new Sound().buttonsound();
                previousLevel();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_DOWN)
                    || inputManager.isKeyDown(KeyEvent.VK_S)) {
                new Sound().buttonsound();
                nextLevel();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_SPACE))
                this.isRunning = false;
        }
    }

    /**
     * Shifts the focus to the next level.
     */
    private void nextLevel() {
        // returnCode
        // 400070 = LevelScreen
        // 400080 = Easy
        // 400090 = Normal
        // 400100 = Hard
        // 400110 = Return To Main Menu
        // 400120 = Exit Program
        if (this.returnCode == 400080)
            this.returnCode = 400090;
        else if (this.returnCode == 400090)
            this.returnCode = 400100;
        else if (this.returnCode == 400100)
            this.returnCode = 400110;
        else if (this.returnCode == 400110)
            this.returnCode = 400120;
        else if (this.returnCode == 400120)
            this.returnCode = 400130;
        else if (this.returnCode == 400130)
            this.returnCode = 400080;
    }

    /**
     * Shifts the focus to the previous level.
     */
    private void previousLevel() {
        // returnCode
        // 400070 = LevelScreen
        // 400080 = Easy
        // 400090 = Normal
        // 400100 = Hard
        // 400110 = Return To Main Menu
        // 400120 = Exit Program
        if (this.returnCode == 400080)
            this.returnCode = 400130;
        else if (this.returnCode == 400090)
            this.returnCode = 400080;
        else if (this.returnCode == 400100)
            this.returnCode = 400090;
        else if (this.returnCode == 400110)
            this.returnCode = 400100;
        else if (this.returnCode == 400120)
            this.returnCode = 400110;
        else if (this.returnCode == 400130)
            this.returnCode = 400120;
    }

    /**
     * Draws the elements associated with the screen.
     */
    private void draw() {
        drawManager.initDrawing(this);

        drawManager.drawLevelMenu(this);
        drawManager.drawLevelItems(this, this.returnCode);
        drawManager.completeDrawing(this);
    }
}
