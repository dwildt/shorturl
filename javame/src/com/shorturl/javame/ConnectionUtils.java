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
public class ConnectionUtils {

    private Logger logger;

    public ConnectionUtils(){
        logger=  new Logger();
    }

    public ConnectionUtils(Logger logger){
        this.logger =  logger;
    }


    public String runHttpGetConnection(final String url) throws ShortUrlException{
      HttpConnection connection = null;
      InputStream inputstream = null;
      try
      {
        connection = (HttpConnection) Connector.open(url);
        connection.setRequestMethod(HttpConnection.GET);
        connection.setRequestProperty("Content-Type","//text plain");
        connection.setRequestProperty("Connection", "close");


        if (connection.getResponseCode() == HttpConnection.HTTP_OK)
        {
          debugResponseCode(connection);

          String str;
          inputstream = connection.openInputStream();
          int length = (int) connection.getLength();
          if (length != -1)
          {
            byte incomingData[] = new byte[length];
            inputstream.read(incomingData);
            str = new String(incomingData);
          }
          else
          {
            ByteArrayOutputStream bytestream =
                  new ByteArrayOutputStream();
            int ch;
            while ((ch = inputstream.read()) != -1)
            {
              bytestream.write(ch);
            }
            str = new String(bytestream.toByteArray());
            bytestream.close();
          }
          return str;
        }
        else
            throw new ShortUrlException(new StringBuffer()
                                           .append("Status Line Code: ")
                                           .append(connection.getResponseCode())
                                           .append("\n")
                                           .append("Status Line Message: ")
                                           .append(connection.getResponseMessage()).toString());
      }
      catch(IOException error)
      {
       throw new ShortUrlException("Raised IOException", error);
      }
      finally
      {
        if (inputstream!= null)
        {
          try
          {
            inputstream.close();
          }
          catch( Exception error)
          {
             throw new ShortUrlException("Unknown error",error);
          }
        }
        if (connection != null)
        {
          try
          {
             connection.close();
          }
          catch( Exception error)
          {
             throw new ShortUrlException("Unknown error",error);
          }
        }
      }
    }

    private void debugResponseCode(HttpConnection connection) throws IOException {
        getLogger().debug("Status Line Code: " + connection.getResponseCode());
        getLogger().debug("Status Line Message: " + connection.getResponseMessage());
        getLogger().debug(
          connection.getHeaderField(0)+ " " + connection.getHeaderFieldKey(0));
        getLogger().debug(
          "Header Field Date: " + connection.getHeaderField("date"));
    }

    private Logger getLogger() {
        return logger;
    }

}
