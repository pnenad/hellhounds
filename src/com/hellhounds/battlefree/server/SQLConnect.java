/**
 * Copyright 2014 Endre Koekebakker, Espen Strømland,
 *                Nenad Petkovic, Steven Hicks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hellhounds.battlefree.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnect
{
    private String url = null;
    private String user = null;
    private String passwd = null;

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public SQLConnect()
    {
        FileInputStream filein = null;
        Properties prop = new Properties();

        try
        {
            filein = new FileInputStream("mysql/database.properties");
            prop.load(filein);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
           try{
                if(filein != null) filein.close();
           }catch(IOException ex)
           {
               System.out.println(ex.getMessage());
           }
        }

        this.url = prop.getProperty("db.url");
        this.user = prop.getProperty("db.user");
        this.passwd = prop.getProperty("db.passwd");

    }

    public boolean registerPlayer(String username, String password, String email)
    {
        boolean completed = false;
        if(username == null) return false;

        try
        {
            con = DriverManager.getConnection(url, user, passwd);
            ps = con.prepareStatement(
                    "INSERT INTO player (username, password, email) " +  
                    "VALUES (?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            if(ps.executeUpdate() == 1) completed = true;
        }
        catch(SQLException sqlex)
        {
            System.out.println(sqlex.getMessage());
        }
        finally
        {
            try
            {
                if(con != null) con.close();

                if(ps != null) ps.close();
            }
            catch(SQLException sqlex)
            {
                System.out.println(sqlex.getMessage());
            }
        } 
        return completed; 
    }

    
    public void selectUser()
    {
        try
        {
            con = DriverManager.getConnection(url, user, passwd);
            ps = con.prepareStatement(
                    "SELECT username FROM player"); //where playerID="+id);
            rs = ps.executeQuery();

            while(rs.next())
            {
                System.out.println("Username: "+rs.getString(1));
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if(con != null) con.close();

                if(ps != null) ps.close();

                if(rs != null) rs.close();
            }
            catch(SQLException sqlex)
            {
                System.out.println(sqlex.getMessage());
            }
        }
    }
}
