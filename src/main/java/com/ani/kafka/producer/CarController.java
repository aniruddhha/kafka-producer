package com.ani.kafka.producer;

import com.ani.kafka.producer.domain.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/car")
@RestController
@AllArgsConstructor
public class CarController {

    private final KafkaTemplate<String, Car> kafkaTemplate;

    @GetMapping("/{id}")
    public Car getCar(@PathVariable String id) {
        // get car by id using repository
        final var car = new Car(12L, "abc", 123);
        kafkaTemplate.send("car-topic", car);
        return car;
    }
}
