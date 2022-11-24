package screen;

import static engine.Core.frame;

public class ShakeScreen extends Screen {

    private final static int SHAKE_LENGTH = 15;
    private final static int SHAKE_VELO = 6;

    /**
     * Constructor, establishes the properties of the screen.
     *
     * @param width  Screen width.
     * @param height Screen height.
     * @param fps
     */
    public ShakeScreen(int width, int height, int fps) {

        super(width, height, fps);
    }


    public static void vibrate() {
        try {
            if (HUDSettingScreen.isshake == true) {
                final int originalX = frame.getLocationOnScreen().x;
                final int originalY = frame.getLocationOnScreen().y;
                for (int i = 0; i < SHAKE_LENGTH; i++) {
                    Thread.sleep(10);
                    frame.setLocation(originalX, originalY + SHAKE_VELO);
                    Thread.sleep(10);
                    frame.setLocation(originalX, originalY - SHAKE_VELO);
                    Thread.sleep(10);
                    frame.setLocation(originalX + SHAKE_VELO, originalY);
                    Thread.sleep(10);
                    frame.setLocation(originalX - SHAKE_VELO, originalY);
                    Thread.sleep(10);
                    frame.setLocation(originalX, originalY);
                }
            }
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }
}
