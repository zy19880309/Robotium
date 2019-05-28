package cn.zhangyong.robotium.day1;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * description:
 * autour: zhangyong
 * date: 2019/5/28 15:29
 * update: 2019/5/28
 * version:
 */
@RunWith(AndroidJUnit4.class)
public class WhiteBoxTest {
    private Solo solo;

    @Rule
    public ActivityTestRule<Main2Activity> activityTestRule = new ActivityTestRule<>(Main2Activity.class);

    @Before
    public void initSolo() {
        Solo.Config config = new Solo.Config();
        config.commandLogging = true;
        config.commandLoggingTag = "debuga";
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),config,activityTestRule.getActivity());
    }

    @After
    public void closeSolo() {
        solo.sleep(2000);
    }

    @Test
    public void Test1(){
        solo.unlockScreen();//解锁屏幕
        solo.sleep(1000);//等待1s
        solo.setActivityOrientation(Solo.LANDSCAPE);//横屏，宽>高
        solo.sleep(1000);//等待1s
        solo.setActivityOrientation(Solo.PORTRAIT);//竖屏，宽<高
        solo.sleep(1000);//等待1s
    }
}
