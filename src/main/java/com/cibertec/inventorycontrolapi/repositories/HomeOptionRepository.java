package com.cibertec.inventorycontrolapi.repositories;

import com.cibertec.inventorycontrolapi.entities.HomeOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeOptionRepository extends JpaRepository<HomeOption, Long> {
}
