package com.jin.map;

public class Map {
	 // ��� 
    private String place;

    // �ּ� 
    private String address;

    // x��ǥ(lat) 
    private Float lat;

    // y��ǥ(lng) 
    private Float lng;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

}
