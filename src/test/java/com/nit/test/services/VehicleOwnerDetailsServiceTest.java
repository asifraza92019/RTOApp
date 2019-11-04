package com.nit.test.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.model.VehicleOwnerDetails;
import com.nit.respositories.VehicleOwnerDetailsRepository;
import com.nit.services.VehicleOwnerDetailsService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class VehicleOwnerDetailsServiceTest {
	 @InjectMocks
	private static VehicleOwnerDetailsService vehicleOwnerDetailsService;
	 @Mock
	 private  static VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;
	 @Test
	 public void getVehicleOwnerDetailsByIdTestPositive()
	 {
		 Integer id = new Integer(1);
		 VehicleOwnerDetails vehicleOwnerDetails = new VehicleOwnerDetails();
		 vehicleOwnerDetails.setVehicleOwnerId(id);
		 vehicleOwnerDetails.setFirstName("asif");
		 vehicleOwnerDetails.setLastName("raza");
		 vehicleOwnerDetails.setEmail("asifraza2099@gmail.com");
		 vehicleOwnerDetails.setDob("04//10/1995");
		 vehicleOwnerDetails.setGender("Male");
		 vehicleOwnerDetails.setPhoneNumber("9262869002");
		 vehicleOwnerDetails.setZzn("999-999-999");
		 vehicleOwnerDetails.setCreateDate(new Date());
		 vehicleOwnerDetails.setUpdateDate(new Date());
		 
   VehicleOwnerDetails vhclOwnrDtls= vehicleOwnerDetailsRepository.save(vehicleOwnerDetails);
    VehicleOwnerDetails optional = vehicleOwnerDetailsService.getVehicleOwnerDetailsById(1);      
    assertEquals(vhclOwnrDtls, optional);
		 		 
	 }
}
