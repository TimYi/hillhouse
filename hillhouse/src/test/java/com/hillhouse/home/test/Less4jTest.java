package com.hillhouse.home.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.github.sommeri.less4j.Less4jException;
import com.github.sommeri.less4j.LessCompiler;
import com.github.sommeri.less4j.LessCompiler.CompilationResult;
import com.github.sommeri.less4j.core.DefaultLessCompiler;

public class Less4jTest {
		
	public static void main(String[] args) {
		File lessFile=new File("E:/_Git/hillhouse/hillhouse/src/main/webapp/resources/css/common.less");
		File cssFile=new File("E:/_Git/hillhouse/hillhouse/src/main/webapp/resources/css/common.css");
		LessCompiler compiler=new DefaultLessCompiler();
		try {
			CompilationResult cssResult=compiler.compile(lessFile);
			String css=cssResult.getCss();
			FileUtils.writeStringToFile(cssFile, css);
		} catch (Less4jException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
