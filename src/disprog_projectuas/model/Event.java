/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disprog_projectuas.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Janet Deby Marlien M
 */
public class Event extends myModel {

    int id;
    String nama;
    String penyelenggara;
    Timestamp tanggalEvent;
    int quota;
    String lokasi;

    public Event() {
        this.id = id;
        this.nama = nama;
        this.penyelenggara = penyelenggara;
        this.tanggalEvent = tanggalEvent;
        this.quota = quota;
        this.lokasi = lokasi;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyelenggara() {
        return penyelenggara;
    }

    public void setPenyelenggara(String penyelenggara) {
        this.penyelenggara = penyelenggara;
    }

    public Timestamp getTanggalEvent() {
        return tanggalEvent;
    }

    public void setTanggalEvent(Timestamp tanggalEvent) {
        this.tanggalEvent = tanggalEvent;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    @Override
    public void insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateData() {
        try {
            if (!myModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myModel.conn.prepareStatement("Update tEvents SET quota = ? WHERE id = ?");
                sql.setInt(1, this.quota);
                sql.setInt(2, this.id);

                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("update error " + e);
        }
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collection = new ArrayList<>();
        try {
            this.statement = (Statement) myModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT * FROM tEvents where id = '" + this.id + "'");
            while (this.result.next()) {
                Event event = new Event();
                this.result.getInt("id");
                this.result.getString("nama");
                this.result.getString("penyelenggara");
                this.result.getString("tanggalEvent");
                this.result.getString("lokasi");

                collection.add(event);
            }
        } catch (Exception e) {
            System.out.println("Error di viewList: " + e);
        }
        return collection;
    }

}
