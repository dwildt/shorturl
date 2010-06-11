/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shorturl.javame;

/**
 *
 * @author danielwildt
 */
public class Logger {
    public static final int DEBUG_MODE = 1;
    public static final int PRODUCTION_MODE = 0;

    private int mode; 

    public Logger()
    {
        setMode(PRODUCTION_MODE);
    }

    public Logger activateDebugMode()
    {
        setMode(DEBUG_MODE);
        return this;
    }

    public Logger debug(String debugMessage)
    {
        if(getMode() == DEBUG_MODE)
            System.out.println(debugMessage);
        return this;
    }

    /**
     * @return the mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    private void setMode(int mode) {
        this.mode = mode;
    }

}
