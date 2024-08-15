package com.javaguides.EmployeeManagementSystem.projections;

// import lombok.Value;
import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameWithDomainProjection {
	@Value("#{target.name}")
	String getName();
	
	@Value("#{target.email}")
	String getEmail();

}
