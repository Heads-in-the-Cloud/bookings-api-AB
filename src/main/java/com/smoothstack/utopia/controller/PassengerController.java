package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.exception.*;
import com.smoothstack.utopia.entity.Passenger;
import com.smoothstack.utopia.service.PassengerService;

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
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService service;

    @PostMapping
    public ResponseEntity<Passenger> create(@Valid @RequestBody final Passenger passenger) {
        service.save(passenger);
        return ResponseEntity.ok(passenger);
    }

    @GetMapping
    public @ResponseBody List<Passenger> readAll() {
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> readById(@PathVariable final Integer id) {
        final Passenger passenger = service.selectById(id).orElseThrow(NotFoundException::new);
        return ResponseEntity.ok(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable final Integer id, @Valid @RequestBody final Passenger passenger) {
        if(id != passenger.getId()) {
            throw new InvalidUpdateIdException();
        }
        final Passenger _ogPassenger = service.selectById(id).orElseThrow(NotFoundException::new);
        service.save(passenger);
        return ResponseEntity.ok("Passenger updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Integer id) {
        final Passenger passenger = service.selectById(id).orElseThrow(NotFoundException::new);
        service.delete(passenger);
        return ResponseEntity.noContent().build();
    }
}
