package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.exception.*;
import com.smoothstack.utopia.entity.BookingGuest;
import com.smoothstack.utopia.service.BookingGuestService;

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
@RequestMapping("/api/booking-guests")
public class BookingGuestController {

    private final BookingGuestService service;

    public BookingGuestController(final BookingGuestService service) {
      this.service = service;
    }

    @PostMapping
    public ResponseEntity<BookingGuest> create(@Valid @RequestBody final BookingGuest bookingGuest) {
        service.save(bookingGuest);
        return ResponseEntity.ok(bookingGuest);
    }

    @GetMapping
    public @ResponseBody List<BookingGuest> readAll() {
        return service.selectAll();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingGuest> readById(@PathVariable final Integer bookingId) {
        final BookingGuest bookingGuest = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(bookingGuest);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateById(@PathVariable final Integer bookingId, @Valid @RequestBody final BookingGuest bookingGuest) {
        if(bookingId != bookingGuest.getId().getBooking().getId()) {
            throw new InvalidUpdateIdException();
        }
        final BookingGuest _ogBookingGuest = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.save(bookingGuest);
        return ResponseEntity.ok("Booking Guest updated successfully");
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer bookingId) {
        final BookingGuest bookingGuest = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.delete(bookingGuest);
        return ResponseEntity.noContent().build();
    }
}
