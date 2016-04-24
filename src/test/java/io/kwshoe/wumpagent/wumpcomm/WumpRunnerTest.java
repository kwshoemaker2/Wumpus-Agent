package io.kwshoe.wumpagent.wumpcomm;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class WumpRunnerTest extends TestCase
{
    private BufferedReader mockReader;
    private BufferedWriter mockWriter;
    private WumpRunner wr;

    @Before
    public void setUp()
    {
        mockReader = mock(BufferedReader.class);
        mockWriter = mock(BufferedWriter.class);
        wr = new WumpRunner(mockReader, mockWriter);
    }


    @Test
    public void testSendCmd_cmdHasNoNewline_writeCalledWithNewline() throws Exception
    {
        String cmd = "rm -rf /*";
        wr.sendCmd(cmd);
        verify(mockWriter).write(cmd + "\n");
    }

    @Test
    public void testSendCmd_cmdHasNewline_writeCalledWithCommand() throws Exception
    {
        String cmd = "rm -rf /*\n";
        wr.sendCmd(cmd);
        verify(mockWriter).write(cmd);
    }

    @Test
    public void testSendCmd_cmdBlank_dontWrite() throws Exception
    {
        wr.sendCmd("");
        verify(mockWriter, never()).write("");
        verify(mockWriter, never()).write("\n");
    }

    @Test
    public void testSendCmd_validCmd_flushCalled() throws Exception
    {
        wr.sendCmd("asdf\n");
        verify(mockWriter).flush();
    }

    @Test
    public void testGetOutpout_readerSendsSequence_sequenceCorrectlyObtained() throws Exception
    {
        fail();
    }

    @Test
    public void testGetOutput_outputObtained_wumpOutputReset() throws Exception
    {
        fail();
    }
}
