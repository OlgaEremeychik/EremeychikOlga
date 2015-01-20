/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.oop.courseProject.ServerEremeychikON;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ScheduleEremeychikON {
    String time;
    String program;
    
    public ScheduleEremeychikON(){
        time = null;
        program = null;
    }
    
    public ScheduleEremeychikON(String time, String program) {
        this.time = time;
        this.program = program;
    }
    
    public /*static*/ /*ResultSet*/ ArrayList<ScheduleEremeychikON> receiveSchedule(String radioStation) {
        ArrayList<ScheduleEremeychikON> lst = new ArrayList<>();
        Connection connection;
        ResultSet rs = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection("jdbc:ucanaccess://D:/БГУИР/NetBeansProjects/СourseProjectServerEremeychikON/src/" + radioStation + ".mdb;showschema=true");
            java.sql.Statement st = connection.createStatement();
            
            rs = st.executeQuery("SELECT * FROM ScheduleFirstChannel");
            while(rs.next()) {
                String time = rs.getString(1);
                String program = rs.getString(2);
                //System.out.println(time + " " + program);
                //lst.add(new ScheduleEremeychikON(time, program));
            }
            if(lst.size() <= 0) {
                System.out.println("Not found");
            }
            rs.close();
            st.close();
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return lst;
    }
}
