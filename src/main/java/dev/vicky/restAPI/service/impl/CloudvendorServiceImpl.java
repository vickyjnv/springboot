package dev.vicky.restAPI.service.impl;

import dev.vicky.restAPI.Model.CloudVendor;
import dev.vicky.restAPI.exception.CloudVendorNotFoundException;
import dev.vicky.restAPI.repository.CloudVendorRepository;
import dev.vicky.restAPI.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudvendorServiceImpl implements CloudVendorService {


  CloudVendorRepository cloudVendorRepository;


  public CloudvendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
    this.cloudVendorRepository = cloudVendorRepository;
  }



  @Override
  public String createCloudVendor(CloudVendor cloudVendor) {
    cloudVendorRepository.save(cloudVendor);
    return "Success";
  }

  @Override
  public String updateCloudVendor(CloudVendor cloudVendor) {
    cloudVendorRepository.save(cloudVendor);
    return "Updated";
  }

  @Override
  public String deleteCloudVendor(String cloudVendorId) {
  cloudVendorRepository.deleteById(cloudVendorId);
    return "deleted";
  }

  @Override
  public CloudVendor getCloudVendor(String cloudVendorId) {
    if(cloudVendorRepository.findById(cloudVendorId).isEmpty()) throw new CloudVendorNotFoundException("requested Cloud Vendor Does not Exist");
    return cloudVendorRepository.findById(cloudVendorId).get();
  }

  @Override
  public List<CloudVendor> getAllCloudVendors() {
    return cloudVendorRepository.findAll();
  }
}
