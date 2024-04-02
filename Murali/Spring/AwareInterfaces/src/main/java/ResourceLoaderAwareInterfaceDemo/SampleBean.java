package ResourceLoaderAwareInterfaceDemo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.ResourceLoader;

import jakarta.annotation.Resource;

public class SampleBean implements ResourceLoaderAware {
	
	public ResourceLoader resourceLoader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		// TODO Auto-generated method stub
		this.resourceLoader = resourceLoader;
	}
	
	public void readResource() throws Exception{
		org.springframework.core.io.Resource r =  resourceLoader.getResource("classpath:test.properties");
//		org.springframework.core.io.Resource r =  resourceLoader.getResource("file:file_path");
		
		Properties p = new Properties();
		InputStream is = ((InputStreamSource) r).getInputStream();
		p.load(is);
		
		System.out.println(p.getProperty("key1"));
		System.out.println(p.getProperty("key2"));
		
	}

}
