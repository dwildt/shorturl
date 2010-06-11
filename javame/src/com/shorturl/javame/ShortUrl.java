/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shorturl.javame;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

/**
 *
 * @author danielwildt
 */
public class ShortUrl {

    private Logger logger;

    public ShortUrl(){
        logger=  new Logger();
    }

    public ShortUrl(Logger logger){
        this.logger =  logger;
    }


    public String fromMigreMe(final String url) throws ShortUrlException
    {
        ConnectionUtils connUtils = new ConnectionUtils(logger);

        return connUtils.runHttpGetConnection("http://migre.me/api.txt?url=" + url);
    }


}
