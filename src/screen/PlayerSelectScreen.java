package screen;

import engine.Cooldown;
import engine.Core;

import java.awt.event.KeyEvent;

public class PlayerSelectScreen extends Screen{

    private static final int SELECTION_TIME = 200;
    private Cooldown selectionCooldown;
    private int returnCode;
    private int player;

    public PlayerSelectScreen(final int width, final int height, final int fps) {
        super(width, height, fps);
        this.returnCode = 1;
        this.selectionCooldown = Core.getCooldown(SELECTION_TIME);
        this.selectionCooldown.reset();
    }

    public final int run() {
        super.run();

        return this.returnCode;
    }

    protected final void update() {
        super.update();

        draw();
        if (this.selectionCooldown.checkFinished()
                && this.inputDelay.checkFinished()) {
            if (inputManager.isKeyDown(KeyEvent.VK_UP)
                    || inputManager.isKeyDown(KeyEvent.VK_W)) {
                previousLevel();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_DOWN)
                    || inputManager.isKeyDown(KeyEvent.VK_S)) {
                nextLevel();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_SPACE))
                this.isRunning = false;
        }
    }

    private void nextLevel() {

        if (this.returnCode == 1)
            this.returnCode = 2;
        else if (this.returnCode == 2)
            this.returnCode = 1;
    }

    /**
     * Shifts the focus to the previous level.
     */
    private void previousLevel() {

        if (this.returnCode == 1)
            this.returnCode = 2;
        else if (this.returnCode == 2)
            this.returnCode = 1;
    }

    private void draw() {
        drawManager.initDrawing(this);
        drawManager.drawSelectPlayer(this);
        drawManager.drawSelectItems(this, this.returnCode);
        drawManager.completeDrawing(this);
    }
}
