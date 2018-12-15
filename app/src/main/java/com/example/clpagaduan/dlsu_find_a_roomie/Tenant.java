package com.example.clpagaduan.dlsu_find_a_roomie;

public class Tenant {
    private String tenantID;
    private String tentantSlot;
    private String uid;

    public Tenant (){

    }

    public Tenant(String tenantID, String uid, String tentantSlot) {
        this.tenantID = tenantID;
        this.tentantSlot = tentantSlot;
        this.uid = uid;
    }

    public String getTenantID() {
        return tenantID;
    }

    public String getTentantSlot() {
        return tentantSlot;
    }

    public String getUid(){
        return uid;

    }
}
