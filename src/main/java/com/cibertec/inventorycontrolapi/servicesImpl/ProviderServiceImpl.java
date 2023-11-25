package com.cibertec.inventorycontrolapi.servicesImpl;

import com.cibertec.inventorycontrolapi.entities.Provider;
import com.cibertec.inventorycontrolapi.enums.Status;
import com.cibertec.inventorycontrolapi.repositories.ProviderRepository;
import com.cibertec.inventorycontrolapi.services.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;

    @Override
    @Transactional
    public List<Provider> findAll() throws Exception {
        try {
            return providerRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Provider> findAllActive() throws Exception {
        try {
            return providerRepository
                    .findAll()
                    .stream()
                    .filter(provider -> provider.getStatus() == Status.ACTIVE)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provider findById(Long id) throws Exception {
        try {
            return providerRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provider save(Provider provider) throws Exception {
        try {
            return providerRepository.save(provider);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provider update(Long id, Provider provider) throws Exception {
        try {
            boolean isPresent = providerRepository.findById(id).isPresent();
            return isPresent ? providerRepository.save(provider) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provider delete(Long id) throws Exception {
        try {
            Optional<Provider> optionalProvider = providerRepository.findById(id);

            if (optionalProvider.isPresent()) {
                Provider provider = optionalProvider.get();
                provider.setStatus(Status.INACTIVE);
                return providerRepository.save(provider);
            }

            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
