package com.example.angularspringfullstackgigproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angularspringfullstackgigproject.Model.DriverModel;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<DriverModel, Long> {
    Optional<DriverModel> getDriverByDriverEmail(String email);
}
