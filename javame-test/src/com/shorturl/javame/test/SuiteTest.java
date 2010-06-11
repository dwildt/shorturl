/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shorturl.javame.test;

import j2meunit.framework.Test;
import j2meunit.framework.TestCase;
import j2meunit.framework.TestMethod;
import j2meunit.framework.TestSuite;

/**
 * @author danielwildt
 */
public class SuiteTest extends TestCase{

    public Test suite(){
        TestSuite suite = new TestSuite();

        suite.addTest(new MigreMeTest("Migre.me Integration", new TestMethod()
                {  public void run(TestCase tc) {((MigreMeTest) tc).testShouldReturnNHzzWhenGoogleDotComIsCalled(); } }));

        return suite;
    }

}
