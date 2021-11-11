package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.exception.*;
import com.smoothstack.utopia.entity.BookingPayment;
import com.smoothstack.utopia.service.BookingPaymentService;

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
@RequestMapping("/api/booking-payments")
public class BookingPaymentController {

    private final BookingPaymentService service;

    @PostMapping
    public ResponseEntity<BookingPayment> create(@Valid @RequestBody final BookingPayment bookingPayment) {
        service.save(bookingPayment);
        return ResponseEntity.ok(bookingPayment);
    }

    @GetMapping
    public @ResponseBody List<BookingPayment> readAll() {
        return service.selectAll();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingPayment> readById(@PathVariable final Integer bookingId) {
        final BookingPayment bookingPayment = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(bookingPayment);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateById(@PathVariable final Integer bookingId, @Valid @RequestBody final BookingPayment bookingPayment) {
        if(bookingId != bookingPayment.getId().getBooking().getId()) {
            throw new InvalidUpdateIdException();
        }
        final BookingPayment _ogBookingPayment = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.save(bookingPayment);
        return ResponseEntity.ok("Booking Payment updated successfully");
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer bookingId) {
        final BookingPayment bookingPayment = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.delete(bookingPayment);
        return ResponseEntity.noContent().build();
    }
}
