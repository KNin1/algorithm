package top.knin1.algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class BrowserSampleTest {
    @Test
    public void testBrowserSample() {
        BrowserSample browser = new BrowserSample();
        browser.open("www.biying.com");
        browser.open("www.baidu.com");
        browser.open("www.google.com");

        Assert.assertNull(browser.forward());

        String info = browser.backward();
        System.out.println(info);
        Assert.assertEquals("www.baidu.com", info);

        info = browser.backward();
        System.out.println(info);
        Assert.assertEquals("www.biying.com", info);

        browser.open("www.zhibo8.cc");

        info = browser.backward();
        System.out.println(info);
        Assert.assertEquals("www.biying.com", info);

        info = browser.forward();
        System.out.println(info);
        Assert.assertEquals("www.zhibo8.cc", info);

        info = browser.backward();
        System.out.println(info);
        Assert.assertEquals("www.biying.com", info);
    }
}
