package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.exception.*;
import com.smoothstack.utopia.entity.FlightBooking;
import com.smoothstack.utopia.service.FlightBookingService;

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

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/flight-bookings")
public class FlightBookingController {

    private final FlightBookingService service;

    @PostMapping
    public ResponseEntity<FlightBooking> create(@Valid @RequestBody final FlightBooking flightBooking) {
        service.save(flightBooking);
        return ResponseEntity.ok(flightBooking);
    }

    @GetMapping
    public @ResponseBody List<FlightBooking> readAll() {
        return service.selectAll();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<FlightBooking> readById(@PathVariable final Integer bookingId) {
        final FlightBooking flightBooking = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(flightBooking);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateById(@PathVariable final Integer bookingId, @Valid @RequestBody final FlightBooking flightBooking) {
        if(bookingId != flightBooking.getId().getBooking().getId()) {
            throw new InvalidUpdateIdException();
        }
        final FlightBooking _ogflightBooking = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.save(flightBooking);
        return ResponseEntity.ok("Flight Bookings updated successfully");
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer bookingId) {
        final FlightBooking flightBooking = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.delete(flightBooking);
        return ResponseEntity.noContent().build();
    }
}
