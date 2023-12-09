package com.extreamsoft.productservice.controller;

import com.extreamsoft.productservice.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final CommandGateway commandGateway;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductRestModel createModel){

        CreateProductCommand command = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .price(createModel.getPrice())
                .title(createModel.getTitle())
                .quantity(createModel.getQuantity())
                .build();

        String response;

        try{
            response = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            response = e.getLocalizedMessage();
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(){
        return ResponseEntity.ok("");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") String id){
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id){
        return ResponseEntity.ok("");
    }
}
