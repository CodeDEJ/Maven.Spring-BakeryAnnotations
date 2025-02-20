package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bakers")
public class BakerController {
    private BakerService service;
    @Autowired
    public BakerController(BakerService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @GetMapping("/{bakerId}")
    public ResponseEntity<Baker> show(@PathVariable("bakerId") Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @PutMapping("{bakerId}")
    public ResponseEntity<Baker> update(@PathVariable("bakerId") Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @DeleteMapping("{bakerId}")
    public ResponseEntity<Boolean> destroy(@PathVariable("bakerId") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
