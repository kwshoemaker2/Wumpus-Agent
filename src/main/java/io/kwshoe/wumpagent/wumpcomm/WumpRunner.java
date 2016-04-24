package io.kwshoe.wumpagent.wumpcomm;

import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class WumpRunner extends Thread
{
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private String wumpOut = "";

    public WumpRunner(BufferedReader read, BufferedWriter write)
    {
        reader = read;
        writer = write;
    }

    @Override
    public void run()
    {
        int c;
        try {
            while((c = reader.read()) != -1) {
                wumpOut += (char)c;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendCmd(String cmd) throws IOException
    {
        if(cmd.length() > 0) {
            if(cmd.charAt(cmd.length()-1) != '\n') {
                cmd += '\n';
            }
            writer.write(cmd);
            writer.flush();
        }
    }

    public synchronized String getOutput()
    {
        String copy = new String(wumpOut);
        wumpOut = "";
        return copy;
    }
}
