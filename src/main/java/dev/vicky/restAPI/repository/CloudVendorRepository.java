package dev.vicky.restAPI.repository;

import dev.vicky.restAPI.Model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
}
