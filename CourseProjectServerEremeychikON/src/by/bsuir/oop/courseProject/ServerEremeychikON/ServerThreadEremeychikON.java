/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.oop.courseProject.ServerEremeychikON;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author HP
 */
public class ServerThreadEremeychikON extends Thread {
    private final PrintStream os; //передача
    private final BufferedReader is; //прием
    private final InetAddress addr; //адрес клиента
    
    public ServerThreadEremeychikON(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
    }
    
    @Override
    public void run() {
        String str;
        try {
            while ((str = is.readLine()) != null) {
                if(str.indexOf("Assessment") != -1) {
                    String radioStation;
                    String ok;
                    String badly;
                    radioStation = is.readLine();
                    ok = is.readLine();
                    badly = is.readLine();
                    System.out.println(radioStation + " " + ok + " " + badly);
                    
                    String fileName1 = "Assessment" + radioStation + "Ok.txt";
                    File fileAssessmentOk = new File(fileName1);
                    try {
                        if(!fileAssessmentOk.exists()) {
                            fileAssessmentOk.createNewFile();
                        }
                    
                        PrintWriter out = new PrintWriter(fileAssessmentOk.getAbsoluteFile());
                    
                        try {
                            out.print(ok);
                        } finally {
                            out.close();
                        }
                    } catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                    
                    String fileName2 = "Assessment" + radioStation + "Badly.txt";
                    File fileAssessmentBadly = new File(fileName2);
                    try {
                        if(!fileAssessmentBadly.exists()) {
                            fileAssessmentBadly.createNewFile();
                        }
                    
                        PrintWriter out = new PrintWriter(fileAssessmentBadly.getAbsoluteFile());
                    
                        try {
                            out.print(badly);
                        } finally {
                            out.close();
                        }
                    } catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch(IOException e){
            System.err.println("Соединение разорвано");
        } finally {
            disconnect();
        }
    }
    public void disconnect() {
        try {
            if(os != null) {
                os.close();
            }
            if(is != null) {
                is.close();
            }
            System.out.println(addr.getHostName() + "disconnecting");
        } catch(IOException e) {
        } finally {
            this.interrupt();
        }
    }
}
