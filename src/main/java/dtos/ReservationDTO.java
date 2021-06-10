/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.reservation;

import entities.reservation.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peter
 */
public class ReservationDTO {

    private Date expirationDate;

    public ReservationDTO(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ReservationDTO(Reservation reservation) {
        this.expirationDate = reservation.getExpirationDate();
    }

    public static List<ReservationDTO> getAllReservationDtos(List<Reservation> allRerservations) {
        List<ReservationDTO> allReservationsDTOs = new ArrayList<>();
        allRerservations.forEach(reservation -> allReservationsDTOs.add(new ReservationDTO(reservation)));
        return allReservationsDTOs;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
