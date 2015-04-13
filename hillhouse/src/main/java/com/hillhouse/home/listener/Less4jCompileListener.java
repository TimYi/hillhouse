package com.hillhouse.home.listener;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.FileUtils;

import com.github.sommeri.less4j.Less4jException;
import com.github.sommeri.less4j.LessCompiler.CompilationResult;
import com.github.sommeri.less4j.core.DefaultLessCompiler;

public class Less4jCompileListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context=sce.getServletContext();
		String lessFilePath=context.getRealPath("/resources/css/common.less");
		String cssFilePath=context.getRealPath("/resources/css/common.css");
		File lessFile=new File(lessFilePath);
		File cssFile=new File(cssFilePath);
		DefaultLessCompiler compiler=new DefaultLessCompiler();
		try {
			CompilationResult cssResult=compiler.compile(lessFile);
			String css=cssResult.getCss();
			FileUtils.writeStringToFile(cssFile, css);
		} catch (Less4jException | IOException e) {
			throw new RuntimeException(e);
		}		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
