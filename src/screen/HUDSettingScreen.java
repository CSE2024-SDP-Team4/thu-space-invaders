package screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import engine.Cooldown;
import engine.Core;
import engine.Sound;


/**
 * Implements the HUD setting screen, it shows setting menu about HUD.
 */

public class HUDSettingScreen extends Screen {
    /**
     * Screen change parameter
     */
    public static int onoffchange;
    public static int colorchange;

    public static boolean isshake = true;
    public static boolean isTransition = true;
    /** Milliseconds between changes in user selection. */
    private static final int SELECTION_TIME = 200;

    /** Time between changes in user selection. */
    private Cooldown selectionCooldown;

    /**
     * Constructor, establishes the properties of the screen.
     *
     * @param width
     *            Screen width.
     * @param height
     *            Screen height.
     * @param fps
     *            Frames per second, frame rate at which the game is run.
     */
    public HUDSettingScreen(final int width, final int height, final int fps) {
        super(width, height, fps);
        this.colorchange = 1;
        this.onoffchange = 0;
        this.isshake = true;
        this.isTransition = true;
        this.returnCode = 4;

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

            if (inputManager.isKeyDown(KeyEvent.VK_LEFT)
                    || inputManager.isKeyDown(KeyEvent.VK_A)) {
                new Sound().buttonsound();
                previousONOFFChange();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_RIGHT)
                    || inputManager.isKeyDown(KeyEvent.VK_D)) {
                new Sound().buttonsound();
                nextONOFFChange();
                this.selectionCooldown.reset();
            }

            if (inputManager.isKeyDown(KeyEvent.VK_UP)
                    || inputManager.isKeyDown(KeyEvent.VK_W)) {
                new Sound().buttonsound();
                previousItem();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_DOWN)
                    || inputManager.isKeyDown(KeyEvent.VK_S)) {
                new Sound().buttonsound();
                nextItem();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_SPACE))
                this.isRunning = false;
            if (this.colorchange == 1)
                changeScreenShake();

        }
    }

    private void nextONOFFChange(){
        int shakenextonoffchange = 1;

        if(this.onoffchange == shakenextonoffchange)
            this.onoffchange = 0;
        else if(this.onoffchange == 0){
            this.onoffchange = 1;
        }


    }

    private void previousONOFFChange(){
        int shakepreonoffchange = 1;

        if(this.onoffchange == 0)
            this.onoffchange = shakepreonoffchange;
        else if(this.onoffchange == 1)
            this.onoffchange = 0;

    }

    private void nextItem(){
        if(this.colorchange == 5) {
            this.colorchange = 1;
            this.onoffchange = 0;
        }
        else if(this.colorchange == 1){
            this.colorchange = 2;
            this.onoffchange = 0;
        }
        else if(this.colorchange == 2){
            this.colorchange = 3;
            this.onoffchange = 0;
        }
        else if(this.colorchange == 3){
            this.colorchange = 4;
            this.onoffchange = 0;
        }
        else if(this.colorchange == 4){
            this.colorchange = 5;
            this.onoffchange = 0;
        }
    }

    private void previousItem(){
        if(this.colorchange == 1){
            this.colorchange = 5;
            this.onoffchange = 0;
        }
        else if(this.colorchange == 5){
            this.colorchange = 4;
            this.onoffchange = 0;
        }
        else if(this.colorchange == 4){
            this.colorchange = 3;
            this.onoffchange = 0;
        }
        else if(this.colorchange == 3){
            this.colorchange = 2;
            this.onoffchange = 0;
        }
        else if(this.colorchange == 2){
            this.colorchange = 1;
            this.onoffchange = 0;
        }
    }

    /**
     * Draws the elements associated with the screen.
     */
    private void draw() {
        drawManager.initDrawing(this);
        drawManager.drawHUDSettingMenu(this, this.colorchange);
        drawManager.drawHUDSettingOption(this, this.colorchange, onoffchange);
        drawManager.drawHUDSettingOption2(this, this.colorchange, onoffchange);
        drawManager.completeDrawing(this);
    }

    /**
     * Exchange colors according to 'colorchange' parameter
     * 
     * @return Color information
     */
    public static Color getScreenColor(){
        if(HUDSettingScreen.colorchange == 3){
            return Color.GREEN;
        }
        else if(HUDSettingScreen.colorchange == 4){
            return Color.RED;
        }
        else if(HUDSettingScreen.colorchange == 5){
            return Color.BLUE;
        }
        else{

            return Color.GREEN;

        }
    }

    public static void changeScreenShake(){
        if(HUDSettingScreen.onoffchange == 0){
            HUDSettingScreen.isshake = true;
        }
        else{
            HUDSettingScreen.isshake = false;
        }

    }

    public void changeScreenTransition() {
        if(this.onoffchange == 0) {
            this.isTransition = true;
        }
        else {
            this.isTransition = false;
        }
    }

}