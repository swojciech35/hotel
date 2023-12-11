package com.tijo.kw.hotel.reservation.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class MakeReservationDto {
    UUID typeOfRoomId;
    ReservationRangeDto reservationRange;
    boolean allInclusive;
    UUID userId;
}
