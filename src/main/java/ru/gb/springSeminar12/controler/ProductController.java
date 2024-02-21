package ru.gb.springSeminar12.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.springSeminar12.model.Product;
import ru.gb.springSeminar12.services.FileGateWay;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final FileGateWay fileGateWay;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        fileGateWay.writeToFile(product.getName()+".txt",product.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
