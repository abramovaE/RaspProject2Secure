package com.springapp.mvc.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by kot on 07.03.17.
 */
@Entity
@Table(name = "Adresses")
public class Raspberry{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "IP")
    private String ip;

    @Column(name = "Adress")
    private String adress;


    @Column(name = "Primechanie")
    private String primechanie;

    @Column(name = "isWork",  columnDefinition = "BIT")
    private boolean isWork;

    @Column(name = "fallendate")
    private Timestamp fallenDate;

    @Column(name = "risendate")
    private Timestamp risenDate;

    @Column(name = "uptime")
    private int uptime;

    @Column(name = "downtime")
    private int downtime;

    public Timestamp getFallenDate() {
        return fallenDate;
    }

    public void setFallenDate(Timestamp fallenDate) {
        this.fallenDate = fallenDate;
    }

    public Timestamp getRisenDate() {
        return risenDate;
    }

    public void setRisenDate(Timestamp risenDate) {
        this.risenDate = risenDate;
    }

    public int getUptime() {
        return uptime;
    }

    public void setUptime(int uptime) {
        this.uptime = uptime;
    }

    public int getDowntime() {
        return downtime;
    }

    public void setDowntime(int downtime) {
        this.downtime = downtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPrimechanie() {
        return primechanie;
    }

    public void setPrimechanie(String primechanie) {
        this.primechanie = primechanie;
    }

    public boolean getIsWork() {
        return isWork;
    }

    public void setIsWork(boolean isWork) {
        this.isWork = isWork;
    }


        public String getTimeDiff(int sec){
            if(sec>0) {
                int days = sec / 86400;
                int hours = (sec % 86400) / 3600;
                int minutes = ((sec % 86400) % 3600) / 60;
                int seconds = ((sec % 86400) % 3600) % 60;

                return "days: " + days + ",hours: " + hours + ",minutes: " + minutes + ",seconds: " + seconds;
            }
            else return null;
    }

}