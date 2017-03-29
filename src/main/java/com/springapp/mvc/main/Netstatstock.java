//package com.springapp.mvc.main;
//
//
//import com.mysql.fabric.jdbc.FabricMySQLDriver;
//import org.apache.log4j.Logger;
//
//import java.io.*;
//import java.util.*;
//import java.sql.*;
//
///**
// * Created by kot on 27.03.17.
// */
//public class Netstatstock {
//
//    private static final String URL ="jdbc:mysql://localhost:3306/RadioRasp";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//    private static Map<String, Boolean> raspFromDB = new HashMap<>();
//    private static final String UPDATEFALL = "UPDATE Adresses SET iswork=?, uptime=TIMESTAMPDIFF(SECOND ,risendate, CURRENT_TIMESTAMP), downtime = 0, fallendate=CURRENT_TIMESTAMP WHERE ip=?";
//    private static final String UPDATERISE = "UPDATE Adresses SET iswork=?, downtime=TIMESTAMPDIFF(SECOND , fallendate, CURRENT_TIMESTAMP), uptime = 0, risendate=CURRENT_TIMESTAMP WHERE ip=?";
//    private static final String INSERT_NEW = "INSERT INTO Adresses(iswork, IP, risendate) values (?, ?, CURRENT_TIMESTAMP )";
//
//
//    //minuta: SECUND = 60;
//    public static final int SLEEPSEC = 20;
//
//    private static Logger logger = Logger.getLogger(Netstatstock.class.getName());
//
//    public static void mainMethod(){
//
//        String fileName = "/home/kot/netstatstok1";
//
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//
//        } catch (SQLException e) {
//            System.out.println("connection to database failed!");
//        }
//
//        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()){
//            ResultSet s = statement.executeQuery("select IP, iswork from Adresses");
//
//            while (s.next()){
//                raspFromDB.put(s.getString("IP"), s.getBoolean("iswork"));
//            }
//
//            Thread thread = Thread.currentThread();
//
////читаем нетстатсток в лист, сравниваем с картой, если различаются, пишем в карту и в базу различия, если нет, оставляем как есть
//            while (true){
//                List<String> listOfNetstatstock = readNetstatstock(fileName);
//                isChanged(listOfNetstatstock, raspFromDB, connection);
//                thread.sleep(SLEEPSEC*1000);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static List<String> readNetstatstock(String fileName){
//        List<String> list = new ArrayList<>();
//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
//            String s;
//            while ((s=bufferedReader.readLine())!=null){
//
//                if(s.startsWith("tcp")){
//                    String[] mass = s.split(" +");
//
//                    s = mass[4];
//                    s=s.substring(0, s.indexOf(":"));
//
//                    if(s.startsWith("10")){
//                        list.add(s.trim());
//                    }
//                }
//            }
//            bufferedReader.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
//
//    public static void isChanged(List<String> listOfNTS, Map<String, Boolean> raspFromDB, Connection connection){
//        try {
//
//            for(Map.Entry<String, Boolean> pair: raspFromDB.entrySet()){
//                String ip = pair.getKey();
//                Boolean state = pair.getValue();
//
//                if(listOfNTS.contains(ip)){
//                    if(state == false){
//                        statementForUpdate(connection, UPDATERISE, ip, true);
////                    PreparedStatement preparedStatement = connection.prepareStatement(UPDATERISE);
////                    preparedStatement.setBoolean(1, true);
////                    preparedStatement.setString(2, ip);
////                    preparedStatement.executeUpdate();
////                    raspFromDB.put(ip, true);
//
//                        ResultSet set = statementForTiming(connection, ip);
//                        int downtime = set.getInt("downtime");
//                        String adress = set.getString("Adress");
//                        logger.info(adress+" "+ip+ " risen, downtime: "+getTimeDiff(downtime));
//                    }
//                }
//
//                else if(!listOfNTS.contains(ip)){
//                    if(state == true){
//                        statementForUpdate(connection, UPDATEFALL, ip, false);
////                    PreparedStatement preparedStatement = connection.prepareStatement(UPDATEFALL);
////                    preparedStatement.setBoolean(1, false);
////                    preparedStatement.setString(2, ip);
////                    preparedStatement.executeUpdate();
////                    raspFromDB.put(ip, false);
//
//                        ResultSet set = statementForTiming(connection, ip);
//                        int uptime = set.getInt("uptime");
//                        String adress = set.getString("Adress");
//                        logger.info(adress+" "+ip+ " fallen, uptime: "+getTimeDiff(uptime));
//
//                    }
//                }
//
//            }
//
//            for(String s: listOfNTS){
//                if(!raspFromDB.containsKey(s)){
//                    statementForUpdate(connection, INSERT_NEW, s, true);
////                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
////                preparedStatement.setBoolean(2, true);
////                preparedStatement.setString(1, s);
////                preparedStatement.executeUpdate();
////                raspFromDB.put(s, true);
//
//                    logger.info(s+ " risen");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//    public static String getTimeDiff(int sec){
//        int days = sec/86400;
//        int hours = (sec%86400)/3600;
//        int minutes = ((sec%86400)%3600)/60;
//        int seconds = ((sec%86400)%3600)%60;
//
//        return "days: "+days+",hours: "+hours+",minutes: "+minutes+",seconds: "+seconds;
//    }
//
//
//    public static ResultSet statementForTiming(Connection connection, String ip){
//        PreparedStatement statement = null;
//        ResultSet set = null;
//        try {
//            statement = connection.prepareStatement("select * from Adresses where ip=?");
//            statement.setString(1, ip);
//            set = statement.executeQuery();
//            set.beforeFirst();
//            set.next();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }return set;
//    }
//
//
//    public static void statementForUpdate(Connection connection, String update, String ip, boolean newState){
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(update);
//
//            preparedStatement.setBoolean(1, newState);
//            preparedStatement.setString(2, ip);
//            preparedStatement.executeUpdate();
//            raspFromDB.put(ip, newState);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
