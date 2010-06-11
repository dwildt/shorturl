/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shorturl.javame.test;

import com.shorturl.javame.Logger;
import com.shorturl.javame.ShortUrl;
import com.shorturl.javame.ShortUrlException;
import j2meunit.framework.TestCase;
import j2meunit.framework.TestMethod;

/**
 *
 * @author danielwildt
 */
public class MigreMeTest extends TestCase {

    public MigreMeTest(String string, TestMethod tm) {
        super(string, tm);
    }

    private ShortUrl shortUrl;

    protected void setUp() throws Exception {
        super.setUp();
        shortUrl = new ShortUrl(new Logger().activateDebugMode());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        shortUrl = null;
    }

    protected void testShouldReturnNHzzWhenGoogleDotComIsCalled()
    {
        try {
            assertEquals("Should return http://migre.me/NHzz", 
                         "http://migre.me/NHzz",
                         shortUrl.fromMigreMe("http://www.google.com"));
        } catch (ShortUrlException ex) {
            fail("Should not fail calling Migre.me service");
            ex.printStackTrace();
        }
    }



}
