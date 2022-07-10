package com.cg.ofr.testdto;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.dto.TenantDto;


@SpringBootTest
class TenantDtoTest {

	
	
		static TenantDto tenantDto;
		
		@BeforeAll
		static void setUp() {
			tenantDto=new TenantDto();
			tenantDto.setTenant_id(2345);
			tenantDto.setAge(45);
			
		}

		

		@Test
		void testGetters() {
			
			assertEquals(2345,tenantDto.getTenant_id());
			assertEquals(45,tenantDto.getAge());
			
		}

	}