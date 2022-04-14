package bach.shoestore.controller;

import bach.shoestore.Dto.ProductDTO;
import bach.shoestore.Dto.ResponseDTO;
import bach.shoestore.Entity.Product;
import bach.shoestore.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private ProductService productService;
    @Autowired

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping(value = "/add")
    public ResponseDTO addProduct(@RequestBody ProductDTO productDTO) {
        ResponseDTO response = new ResponseDTO();
        response = productService.AddProduct(productDTO);
        return response;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteProduc(@PathVariable(name = "id") Integer productId) {
        ResponseDTO response = new ResponseDTO();
        response = productService.deleteProduct(productId);
        return response;
    }
}
