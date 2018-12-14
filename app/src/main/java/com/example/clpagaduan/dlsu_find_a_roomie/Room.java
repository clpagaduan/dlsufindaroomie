package com.example.clpagaduan.dlsu_find_a_roomie;

public class Room {
    String roomID;
    String roomName;
    String roomBed;
    String roomBath;
    String roomRent;
    String roomGen;

    public Room(){

    }

    public Room(String roomID, String roomName, String roomBed, String roomBath, String roomRent, String roomGen){
        this.roomID     = roomID;
        this.roomName   = roomName;
        this.roomBed    = roomBed;
        this.roomBath   = roomBath;
        this.roomRent   = roomRent;
        this.roomGen    = roomGen;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomBed() {
        return roomBed;
    }

    public String getRoomBath() {
        return roomBath;
    }

    public String getRoomRent() {
        return roomRent;
    }

    public String getRoomGen() {
        return roomGen;
    }
}
