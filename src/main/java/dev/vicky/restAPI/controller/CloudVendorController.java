package dev.vicky.restAPI.controller;

import dev.vicky.restAPI.Model.CloudVendor;
import dev.vicky.restAPI.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")

public class CloudVendorController {

  CloudVendorService cloudVendorService;

  public CloudVendorController(CloudVendorService cloudVendorService) {
    this.cloudVendorService = cloudVendorService;
  }


  @GetMapping("{vendorId}")
  public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
    return cloudVendorService.getCloudVendor(vendorId );
  }
  @GetMapping()
  public List<CloudVendor> getAllCloudVendorDetails(){
    return cloudVendorService.getAllCloudVendors();
  }

@PostMapping
  public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
    cloudVendorService.createCloudVendor(cloudVendor);
    return "Cloudvendor added";
  }
@PutMapping
  public String updtaeCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
    cloudVendorService.createCloudVendor(cloudVendor);
    return "Cloudvendor updated";
  }

  @DeleteMapping("{vendorId}")
  public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
    cloudVendorService.deleteCloudVendor(vendorId);
    return "Cloudvendor deleted";
  }
}



