package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.exception.*;
import com.smoothstack.utopia.entity.FlightBookings;
import com.smoothstack.utopia.service.FlightBookingsService;

import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/flight-bookings")
public class FlightBookingsController {

    private final FlightBookingsService service;

    public FlightBookingsController(final FlightBookingsService service) {
      this.service = service;
    }

    @PostMapping
    public ResponseEntity<FlightBookings> create(@Valid @RequestBody final FlightBookings flightBookings) {
        service.save(flightBookings);
        return ResponseEntity.ok(flightBookings);
    }

    @GetMapping
    public @ResponseBody List<FlightBookings> readAll() {
        return service.selectAll();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<FlightBookings> readById(@PathVariable final Integer bookingId) {
        final FlightBookings flightBookings = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(flightBookings);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateById(@PathVariable final Integer bookingId, @Valid @RequestBody final FlightBookings flightBookings) {
        if(bookingId != flightBookings.getId().getBooking().getId()) {
            throw new InvalidUpdateIdException();
        }
        final FlightBookings _ogflightBookings = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.save(flightBookings);
        return ResponseEntity.ok("Flight Bookings updated successfully");
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer bookingId) {
        final FlightBookings flightBookings = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.delete(flightBookings);
        return ResponseEntity.noContent().build();
    }
}
