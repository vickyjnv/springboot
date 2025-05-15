package dev.vicky.restAPI.service;

import dev.vicky.restAPI.Model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
  public String createCloudVendor(CloudVendor cloudVendor);
  public String updateCloudVendor(CloudVendor cloudVendor);
  public String deleteCloudVendor(String cloudVendorId);
  public CloudVendor getCloudVendor(String cloudVendorId);
  public List<CloudVendor> getAllCloudVendors();
}
