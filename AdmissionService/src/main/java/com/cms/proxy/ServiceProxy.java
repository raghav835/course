package com.cms.proxy;

import com.cms.model.Service;

public interface ServiceProxy {
	
	Service getServiceById(String serviceId);
	
	void addService(Service service);
	
	void updateService(Service service);
	
	void deleteService(String serviceId);
	
	// Add more methods as per your service-related operations
}
