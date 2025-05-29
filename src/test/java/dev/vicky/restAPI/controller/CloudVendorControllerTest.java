package dev.vicky.restAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import dev.vicky.restAPI.Model.CloudVendor;
import dev.vicky.restAPI.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {


  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private CloudVendorService cloudVendorService;
  CloudVendor cloudVendorOne;
  CloudVendor cloudVendorTwo;
  List<CloudVendor> cloudVendorList=new ArrayList<>();

  @BeforeEach
  void setUp() {
    cloudVendorOne=new CloudVendor("1","Amazon","USA","9784");
    cloudVendorTwo=new CloudVendor("2","GCP","UK","978467");
    cloudVendorList.add(cloudVendorOne);
    cloudVendorList.add(cloudVendorTwo);

  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void testGetCloudVendorDetails() throws Exception {
    when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
    this.mockMvc.perform(get("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  void testGetAllCloudVendorDetails() throws Exception{
    when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);


    this.mockMvc.perform(get("/cloudvendor")).andDo(print()).andExpect(status().isOk());

  }

  @Test
  void testCreateCloudVendorDetails() throws Exception {
    ObjectMapper mapper=new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
    ObjectWriter ow =mapper.writer().withDefaultPrettyPrinter();
    String requestJson=ow.writeValueAsString(cloudVendorOne);

    when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
    this.mockMvc.perform(post("/cloudvendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());

  }

  @Test
  void TestUpdtaeCloudVendorDetails() throws Exception {

    ObjectMapper mapper=new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
    ObjectWriter ow =mapper.writer().withDefaultPrettyPrinter();
    String requestJson=ow.writeValueAsString(cloudVendorOne);

    when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
    this.mockMvc.perform(put("/cloudvendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());

  }

  @Test
  void testDeleteCloudVendorDetails() throws Exception{
    when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Cloudvendor deleted");
    this.mockMvc.perform(delete("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
  }
}