package SpringBoot_Profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import SpringBoot_Profiles.Beans.MyDataSource;

@Configuration
@PropertySource("classpath:mydatasource.properties")
public class MyConfiguration {	
	@Bean
	MyDataSource datasource(@Value("${mydatasource.username}") String username,
							@Value("${mydatasource.password}") String password) {
		MyDataSource obj = new MyDataSource();
		obj.setUsername(username);
		obj.setPassword(password);
		System.out.println("---------------------------------------------------");
		System.out.println("Username : "+username+" --- "+"Password : "+password);
		System.out.println("---------------------------------------------------");
		return obj;
	}
}
