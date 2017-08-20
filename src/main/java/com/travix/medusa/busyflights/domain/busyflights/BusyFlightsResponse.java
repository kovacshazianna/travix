package com.travix.medusa.busyflights.domain.busyflights;

import com.travix.medusa.busyflights.domain.common.Destination;
import com.travix.medusa.busyflights.domain.common.Supplier;

import java.time.LocalDateTime;
import java.util.Objects;

public class BusyFlightsResponse {
    private String airline;
    private Supplier supplier;
    private Double fair;
    private Destination departureAirCode;
    private Destination destinationAirportCode;
    private String departureDate;
    private String arrivalDate;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Double getFair() {
        return fair;
    }

    public void setFair(Double fair) {
        this.fair = fair;
    }

    public Destination getDepartureAirCode() {
        return departureAirCode;
    }

    public void setDepartureAirCode(Destination departureAirCode) {
        this.departureAirCode = departureAirCode;
    }

    public Destination getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(Destination destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusyFlightsResponse response = (BusyFlightsResponse) o;
        return Objects.equals(airline, response.airline) &&
                supplier == response.supplier &&
                Objects.equals(fair, response.fair) &&
                departureAirCode == response.departureAirCode &&
                destinationAirportCode == response.destinationAirportCode &&
                Objects.equals(departureDate, response.departureDate) &&
                Objects.equals(arrivalDate, response.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline, supplier, fair, departureAirCode, destinationAirportCode, departureDate, arrivalDate);
    }

    @Override
    public String toString() {
        return "BusyFlightsResponse{" +
                "airline='" + airline + '\'' +
                ", supplier=" + supplier +
                ", fair=" + fair +
                ", departureAirCode=" + departureAirCode +
                ", destinationAirportCode=" + destinationAirportCode +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
