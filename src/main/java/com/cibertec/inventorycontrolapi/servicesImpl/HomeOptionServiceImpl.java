package com.cibertec.inventorycontrolapi.servicesImpl;

import com.cibertec.inventorycontrolapi.entities.HomeOption;
import com.cibertec.inventorycontrolapi.enums.Status;
import com.cibertec.inventorycontrolapi.repositories.HomeOptionRepository;
import com.cibertec.inventorycontrolapi.services.HomeOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeOptionServiceImpl implements HomeOptionService {
    private final HomeOptionRepository homeOptionRepository;

    @Override
    public List<HomeOption> findAll() throws Exception {
        try {
            return homeOptionRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<HomeOption> findByUserType() throws Exception {
        try {
            return homeOptionRepository
                    .findAll()
                    .stream()
                    .filter(category -> Objects.equals(category.getUserType(), "user")
                    ).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<HomeOption> findByMenuType(int menu) throws Exception {
        try {
            return homeOptionRepository
                    .findAll()
                    .stream()
                    .filter(category -> category.getMenu() == menu)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public HomeOption findById(Long id) throws Exception {
        try {
            return homeOptionRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public HomeOption save(HomeOption homeOption) throws Exception {
        try {
            return homeOptionRepository.save(homeOption);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public HomeOption update(Long id, HomeOption homeOption) throws Exception {
        try {
            boolean isPresent = homeOptionRepository.findById(id).isPresent();
            return isPresent ? homeOptionRepository.save(homeOption) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public HomeOption delete(Long id) throws Exception {
        try {
            Optional<HomeOption> optional = homeOptionRepository.findById(id);

            if (optional.isPresent()) {
                HomeOption homeOption = optional.get();
                homeOption.setStatus(Status.INACTIVE);
                return homeOptionRepository.save(homeOption);
            }

            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
