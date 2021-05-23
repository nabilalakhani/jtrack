package jtracer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WindowsProcess
{
    private String processName;

    public WindowsProcess(String processName)
    {
        this.processName = processName;
    }

    public void kill() throws Exception
    {
        
        	System.out.println("its running");
            getRuntime().exec("taskkill /F /IM " + "RemoteApp");
        
    }

    private boolean isRunning() throws Exception
    {
        Process listTasksProcess = getRuntime().exec("tasklist");
        BufferedReader tasksListReader = new BufferedReader(
                new InputStreamReader(listTasksProcess.getInputStream()));

        String tasksLine;

        while ((tasksLine = tasksListReader.readLine()) != null)
        {
            if (tasksLine.contains(processName))
            {
                return true;
            }
        }

        return false;
    }

    private Runtime getRuntime()
    {
        return Runtime.getRuntime();
        
        
        
    }
    
    
    public static void  main(String[] args) throws Exception {
    	
    	
    	Runtime.getRuntime().exec("taskkill /F /IM " + "mstsc.exe");
		
	}
}
