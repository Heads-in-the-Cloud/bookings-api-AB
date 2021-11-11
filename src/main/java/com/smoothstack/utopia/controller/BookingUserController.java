package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.exception.*;
import com.smoothstack.utopia.entity.BookingUser;
import com.smoothstack.utopia.service.BookingUserService;

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
@RequestMapping("/api/booking-users")
public class BookingUserController {

    private final BookingUserService service;

    @PostMapping
    public ResponseEntity<BookingUser> create(@Valid @RequestBody final BookingUser bookingUser) {
        service.save(bookingUser);
        return ResponseEntity.ok(bookingUser);
    }

    @GetMapping
    public @ResponseBody List<BookingUser> readAll() {
        return service.selectAll();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingUser> readById(@PathVariable final Integer bookingId) {
        final BookingUser bookingUser = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(bookingUser);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateById(@PathVariable final Integer bookingId, @Valid @RequestBody final BookingUser bookingUser) {
        if(bookingId != bookingUser.getId().getBooking().getId()) {
            throw new InvalidUpdateIdException();
        }
        final BookingUser _ogBookingUser = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.save(bookingUser);
        return ResponseEntity.ok("Booking User updated successfully");
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer bookingId) {
        final BookingUser bookingUser = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.delete(bookingUser);
        return ResponseEntity.noContent().build();
    }
}
