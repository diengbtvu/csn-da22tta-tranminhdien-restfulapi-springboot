package com.javaweb.dto;

import java.util.Date;
public class ApartmentEquipmentBuilder {
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

    public ApartmentEquipmentBuilder apartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
        return this;
    }

    public ApartmentEquipmentBuilder apartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
        return this;
    }

    public ApartmentEquipmentBuilder minRate(Double minRate) {
        this.minRate = minRate;
        return this;
    }

    public ApartmentEquipmentBuilder floorArea(Double floorArea) {
        this.floorArea = floorArea;
        return this;
    }

    public ApartmentEquipmentBuilder numberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
        return this;
    }

    public ApartmentEquipmentBuilder numberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
        return this;
    }

    public ApartmentEquipmentBuilder rented(Boolean rented) {
        this.rented = rented;
        return this;
    }

    public ApartmentEquipmentBuilder moveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
        return this;
    }

    public ApartmentEquipmentBuilder moveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
        return this;
    }

    public ApartmentEquipmentBuilder equipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
        return this;
    }

    public ApartmentEquipmentBuilder equipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
        return this;
    }

    public ApartmentEquipmentBuilder equipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
        return this;
    }

    public ApartmentEquipmentBuilder brokenFee(Double brokenFee) {
        this.brokenFee = brokenFee;
        return this;
    }



    public ApartmentEquipment build() {
        return new ApartmentEquipment(
                apartmentId, apartmentName, minRate, floorArea,
                numberOfBedrooms, numberOfBathrooms, rented,
                moveInDate, moveOutDate, equipmentId,
                equipmentType, equipmentStatus, brokenFee
        );
    }


}