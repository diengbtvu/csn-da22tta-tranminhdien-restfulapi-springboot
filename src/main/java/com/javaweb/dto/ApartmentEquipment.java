package com.javaweb.dto;

import java.util.Date;

public class ApartmentEquipment {
    private Long apartmentId;
    private String apartmentName;
    private Double minRate;
    private Double floorArea;
    private Integer numberOfBedrooms;
    private Integer numberOfBathrooms;
    private Boolean rented;
    private Date moveInDate;
    private Date moveOutDate;
    private Long equipmentId;
    private String equipmentType;
    private String equipmentStatus;
    private Double brokenFee;


    public ApartmentEquipment(Long apartmentId, String apartmentName, Double minRate, Double floorArea, Integer numberOfBedrooms, Integer numberOfBathrooms, Boolean rented, Date moveInDate, Date moveOutDate, Long equipmentId, String equipmentType, String equipmentStatus, Double brokenFee) {
        this.apartmentId = apartmentId;
        this.apartmentName = apartmentName;
        this.minRate = minRate;
        this.floorArea = floorArea;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.rented = rented;
        this.moveInDate = moveInDate;
        this.moveOutDate = moveOutDate;
        this.equipmentId = equipmentId;
        this.equipmentType = equipmentType;
        this.equipmentStatus = equipmentStatus;
        this.brokenFee = brokenFee;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public Double getMinRate() {
        return minRate;
    }

    public void setMinRate(Double minRate) {
        this.minRate = minRate;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Date getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public Double getBrokenFee() {
        return brokenFee;
    }

    public void setBrokenFee(Double brokenFee) {
        this.brokenFee = brokenFee;
    }
}
