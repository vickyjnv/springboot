package dev.vicky.restAPI.service.impl;

import dev.vicky.restAPI.Model.CloudVendor;
import dev.vicky.restAPI.repository.CloudVendorRepository;
import dev.vicky.restAPI.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CloudvendorServiceImplTest {

  @Mock
  private CloudVendorRepository cloudVendorRepository;
  private CloudVendorService cloudVendorService;
  AutoCloseable autoCloseable;
  CloudVendor cloudVendor;

  @BeforeEach
  void setUp() {
    autoCloseable= MockitoAnnotations.openMocks(this);
    cloudVendorService=new CloudvendorServiceImpl(cloudVendorRepository);
    cloudVendor=new CloudVendor("1","Amazon","USA","9784");
  }

  @AfterEach
  void tearDown() throws Exception {
    autoCloseable.close();
  }

  @Test
  void testCreateCloudVendor() {
    mock(CloudVendor.class);
    mock(CloudVendorRepository.class);

    when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
    assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");
  }

  @Test
  void TestUpdateCloudVendor() {

    mock(CloudVendor.class);
    mock(CloudVendorRepository.class);

    when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
    assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Updated");
  }



  @Test
  void TestGetCloudVendor() {
    mock(CloudVendor.class);
    mock(CloudVendorRepository.class);

    when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
    assertThat(cloudVendorService.getCloudVendor("1").getVendorName()).isEqualTo(cloudVendor.getVendorName());
  }

  @Test
  void testGetAllCloudVendors() {
    mock(CloudVendor.class);
    mock(CloudVendorRepository.class);

    when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
    assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());
  }

  @Test
  void testDeleteCloudVendor() {
    mock(CloudVendor.class);
    mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

    doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());
    assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("deleted");
  }


//  @Test
//  void testGetByVendorName(){
//    mock(CloudVendor.class);
//    mock(CloudVendorRepository.class);
//
//    when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
//
//    assertThat(cloudVendorService.get)
//  }
}