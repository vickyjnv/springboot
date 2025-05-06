package dev.vicky.restAPI.controller;

import dev.vicky.restAPI.Model.CloudVendor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloudvendor")

public class CloudVendorAPIService {

  CloudVendor cloudVendor;

  @GetMapping("{vendorId}")
//  public CloudVendor getCloudVendorDetails(String vendorId){
//    return new CloudVendor("c1","vendor1","Address","xxxx");
//  }

  public CloudVendor getCloudVendorDetails(String vendorId){
    return cloudVendor;
  }
@PostMapping
  public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
    this.cloudVendor=cloudVendor;
    return "Cloudvendor added";
  }
@PutMapping
  public String updtaeCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
    this.cloudVendor=cloudVendor;
    return "Cloudvendor updated";
  }

  @DeleteMapping("{vendorId}")
  public String deleteCloudVendorDetails(String vendorId){
    this.cloudVendor=null;
    return "Cloudvendor deleted";
  }
}



