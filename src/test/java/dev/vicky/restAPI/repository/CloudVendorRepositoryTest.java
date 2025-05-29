package dev.vicky.restAPI.repository;

import dev.vicky.restAPI.Model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {


  @Autowired
  private CloudVendorRepository cloudVendorRepository;
  CloudVendor cloudVendor;

  @BeforeEach
  void setUp() {
    cloudVendor=new CloudVendor("1","Amazon","USA","9784");
    cloudVendorRepository.save(cloudVendor);
  }

  @AfterEach
  void tearDown() {
    cloudVendor=null;
    cloudVendorRepository.deleteAll();
  }

  //Test case sucess
  @Test
  void testFindByVendorName_Found()
  {
    List<CloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("Amazon");
    assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
    assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
  }


  //Test case fail
  @Test
  void testFindByVendorName_NotFound()
  {
    List<CloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("GCP");
    //assertThat(cloudVendorList.isEmpty()).isFalse();
    assertThat(cloudVendorList.isEmpty()).isTrue();
  }



}


