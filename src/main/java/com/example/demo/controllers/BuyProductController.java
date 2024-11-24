package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyProductController {
    private ProductService productService;

    @Autowired
    public BuyProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("purchaseProduct")
    public String purchaseProduct(@RequestParam("productID") int id, Model model) {
        Product p = productService.findById(id);
        int currentInv = p.getInv();

        if (currentInv > 0) {
            p.setInv(currentInv - 1);
            productService.save(p);
            model.addAttribute("message", "you have made a purchase.");
        }
        else {
            model.addAttribute("message", "there's no inventory available for purchase.");
        }

        return "buyProduct";
    }
}
