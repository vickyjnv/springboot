package dev.vicky.restAPI.controller;

import dev.vicky.restAPI.Model.CloudVendor;
import dev.vicky.restAPI.response.ResponseHandler;
import dev.vicky.restAPI.service.CloudVendorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  @ApiOperation(value="cloud vendor Id",notes = "Provide cloud vendor details",response = ResponseEntity.class)
  public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
    return ResponseHandler.responseBuilder("Requested Vendor Details are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));

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



