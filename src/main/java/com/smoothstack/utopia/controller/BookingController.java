package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.exception.*;
import com.smoothstack.utopia.entity.Booking;
import com.smoothstack.utopia.service.BookingService;

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
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    @PostMapping
    public ResponseEntity<Booking> create(@Valid @RequestBody final Booking booking) {
        service.save(booking);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public @ResponseBody List<Booking> readAll() {
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> readById(@PathVariable final Integer id) {
        final Booking booking = service.selectById(id).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable final Integer id, @Valid @RequestBody final Booking booking) {
        if(id != booking.getId()) {
            throw new InvalidUpdateIdException();
        }
        final Booking _ogBooking = service.selectById(id).orElseThrow(NotFoundException::new);
        service.save(booking);
        return ResponseEntity.ok("Booking updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer id) {
        final Booking booking = service.selectById(id).orElseThrow(NotFoundException::new);
        service.delete(booking);
        return ResponseEntity.noContent().build();
    }
}
