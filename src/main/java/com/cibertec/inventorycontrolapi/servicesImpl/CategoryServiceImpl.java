package com.cibertec.inventorycontrolapi.servicesImpl;

import com.cibertec.inventorycontrolapi.entities.Category;
import com.cibertec.inventorycontrolapi.enums.Status;
import com.cibertec.inventorycontrolapi.repositories.CategoryRepository;
import com.cibertec.inventorycontrolapi.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List<Category> findAll() throws Exception {
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Category> findByActive() throws Exception {
        try {
            return categoryRepository
                    .findAll()
                    .stream()
                    .filter(category -> category.getStatus() == Status.ACTIVE
                    ).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Category findById(Long id) throws Exception {
        try {
            return categoryRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Category save(Category category) throws Exception {
        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Category update(Long id, Category category) throws Exception {
        try {
            boolean isPresent = categoryRepository.findById(id).isPresent();
            return isPresent ? categoryRepository.save(category) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Category delete(Long id) throws Exception {
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(id);

            if (optionalCategory.isPresent()) {
                Category category = optionalCategory.get();
                category.setStatus(Status.INACTIVE);
                return categoryRepository.save(category);
            }

            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
