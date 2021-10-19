package com.smoothstack.utopia.controller;

import com.smoothstack.utopia.NotFoundException;
import com.smoothstack.utopia.entity.Passenger;
import com.smoothstack.utopia.service.PassengerService;

import java.util.List;

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
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService service;

    public PassengerController(final PassengerService service) {
      this.service = service;
    }

    @PostMapping
    public ResponseEntity<Passenger> create(@RequestBody final Passenger passenger) {
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
    public ResponseEntity<String> updateById(@PathVariable final Integer id, @RequestBody final Passenger passenger) {
        if(id != passenger.getId()) {
            return new ResponseEntity<String>("Entity ids don't match", HttpStatus.BAD_REQUEST);
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
