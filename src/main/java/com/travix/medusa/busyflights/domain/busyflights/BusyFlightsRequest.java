package com.travix.medusa.busyflights.domain.busyflights;

import com.travix.medusa.busyflights.domain.common.Destination;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class BusyFlightsRequest {

    @NotNull(message = "Origin can't empty!")
    private Destination origin;
    @NotNull(message = "Destination can't empty!")
    private Destination destination;
    @NotNull(message = "Departure date can't empty!")
    private LocalDate departureDate;
    @NotNull(message = "Return date can't empty!")
    private LocalDate returnDate;
    @NotNull(message = "Number of passangers can't empty!")
    private Integer numberOfPassengers;

    public Destination getOrigin() {
        return origin;
    }

    public void setOrigin(final Destination origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(final Destination destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = LocalDate.parse(departureDate);;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = LocalDate.parse(returnDate);
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusyFlightsRequest that = (BusyFlightsRequest) o;
        return origin == that.origin &&
                destination == that.destination &&
                Objects.equals(departureDate, that.departureDate) &&
                Objects.equals(returnDate, that.returnDate) &&
                Objects.equals(numberOfPassengers, that.numberOfPassengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination, departureDate, returnDate, numberOfPassengers);
    }

    @Override
    public String toString() {
        return "BusyFlightsRequest{" +
                "origin=" + origin +
                ", destination=" + destination +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
