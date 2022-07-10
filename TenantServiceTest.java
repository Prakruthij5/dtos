package com.cg.ofr.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.dto.TenantDto;
import com.cg.ofr.entities.Tenant;

import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;
import com.cg.ofr.serviceimpl.TenantService;


@SpringBootTest
class TenantServiceTest {
    @Mock
    private ITenantRepository tenantRepository;
    
    @InjectMocks
    TenantService tenantService=new TenantService();
    static Tenant tenant=new Tenant();
    static TenantDto tenantDto;
    static List<Tenant> tenantList;
    static List<Tenant> tenantList1;
    static List<TenantDto> tenantDtoList;
	
    @BeforeAll
    public static void setUp() {
    	tenantList=new ArrayList<>();
    	tenantList1=new ArrayList<>();
    	tenantDtoList=new ArrayList<>();
    	
    	tenantDto=new TenantDto();
		tenant.setTenant_id(2345);
		tenant.setAge(45);
		tenantList.add(tenant);
		BeanUtils.copyProperties(tenant, tenantDto);
		
    }

	@Test
	void testAddTenant() {
		Mockito.when(tenantRepository.saveAndFlush(tenant)).thenReturn(tenant);
		assertNotNull(tenantService.addTenant(tenantDto));
		
		
	}

	@Test
	void testViewAllTenants() throws TenantNotFoundException {
		Mockito.when(tenantRepository.findAll()).thenReturn(tenantList);
		assertNotNull(tenantService.viewAllTenant());
	}
}
