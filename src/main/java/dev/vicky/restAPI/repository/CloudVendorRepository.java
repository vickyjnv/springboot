package dev.vicky.restAPI.repository;

import dev.vicky.restAPI.Model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
  List<CloudVendor> findByVendorName(String vendorName);
}
