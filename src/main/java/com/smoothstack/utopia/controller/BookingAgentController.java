package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.exception.*;
import com.smoothstack.utopia.entity.BookingAgent;
import com.smoothstack.utopia.service.BookingAgentService;

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
@RequestMapping("/api/booking-agents")
public class BookingAgentController {

    private final BookingAgentService service;

    public BookingAgentController(final BookingAgentService service) {
      this.service = service;
    }

    @PostMapping
    public ResponseEntity<BookingAgent> create(@Valid @RequestBody final BookingAgent bookingAgent) {
        service.save(bookingAgent);
        return ResponseEntity.ok(bookingAgent);
    }

    @GetMapping
    public @ResponseBody List<BookingAgent> readAll() {
        return service.selectAll();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingAgent> readById(@PathVariable final Integer bookingId) {
        final BookingAgent bookingAgent = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(bookingAgent);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateById(@PathVariable final Integer bookingId, @Valid @RequestBody final BookingAgent bookingAgent) {
        if(bookingId != bookingAgent.getId().getBooking().getId()) {
            throw new InvalidUpdateIdException();
        }
        final BookingAgent _ogBookingAgent = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.save(bookingAgent);
        return ResponseEntity.ok("Booking Agent updated successfully");
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer bookingId) {
        final BookingAgent bookingAgent = service.selectByBookingId(bookingId).orElseThrow(NotFoundException::new);
        service.delete(bookingAgent);
        return ResponseEntity.noContent().build();
    }
}
