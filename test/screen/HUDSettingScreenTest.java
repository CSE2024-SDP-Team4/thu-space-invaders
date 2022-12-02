package screen;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HUDSettingScreenTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("GetScreenColor test")
    void getScreenColor() {
        assertEquals(Color.GREEN,HUDSettingScreen.getScreenColor()); // default일때 green인지 check
    }



    @Test
    void changeScreenShake() {
        int tmp = HUDSettingScreen.onoffchange;
        assertEquals(0,tmp); //기본 onoffchange 변수값이 0인지 체크
        HUDSettingScreen.changeScreenShake();
        assertEquals(true,HUDSettingScreen.isshake); // 아까 상태에서 메소드 실행후 isshake 변수 바뀌는지 체크

    }
}