package com.cibertec.inventorycontrolapi.servicesImpl;

import com.cibertec.inventorycontrolapi.entities.Product;
import com.cibertec.inventorycontrolapi.enums.Status;
import com.cibertec.inventorycontrolapi.repositories.ProductRepository;
import com.cibertec.inventorycontrolapi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() throws Exception {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Product> findAllActive() throws Exception {
        try {
            return productRepository
                    .findAll()
                    .stream()
                    .filter(product -> product.getStatus() == Status.ACTIVE)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //TODO can be better
    @Override
    public Product findById(Long id) throws Exception {
        try {
            return productRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product save(Product product) throws Exception {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product update(Long id, Product product) throws Exception {
        try {
            boolean isPresent = productRepository.findById(id).isPresent();
            return isPresent ? productRepository.save(product) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product delete(Long id) throws Exception {
        try {
            Optional<Product> optionalProduct = productRepository.findById(id);

            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setStatus(Status.INACTIVE);
                return productRepository.save(product);
            }

            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
