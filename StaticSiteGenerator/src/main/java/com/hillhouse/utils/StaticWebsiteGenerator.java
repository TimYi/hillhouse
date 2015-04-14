package com.hillhouse.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class StaticWebsiteGenerator {
	
	private Set<String> solvedLinks=new HashSet<String>();
	
	/**
	 * 需要过滤的分隔符，如";"，"?"等
	 */
	public Set<String> separators=new HashSet<String>();
	
	public StaticWebsiteGenerator() {
		separators.add(";");
		separators.add("?");
	}
	
	/**
	 * 保存静态网站的路径
	 */
	public String basePath;
	
	/**
	 * 动态网站跟路径地址
	 * 结尾不带/
	 */
	public String siteUrl;
	
	public void resolve(String siteUrl, String url) {
		this.siteUrl=siteUrl;
		resolve(url);
	}
	
	/**
	 * 解析，不对路径做任何处理，需要确保resolve处理的是处理过的标准路径，以/开始。
	 * @param url
	 */
	public void resolve(String url) {
		String content=resolveLink(url);
		try {
			save(url, content);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}		
		Set<String> rawLinks=readLinks(content);
		Set<String> links=getUnresolvedLinks(rawLinks);
		for (String link : links) {
			String httpLink=siteUrl+link;
			try {
				resolve(httpLink);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
	
	/**
	 * 将网页内容按照一定规则持久化
	 * @param url
	 * @param content
	 */
	protected void save(String url, String content) throws IOException {
		url=url.replace(siteUrl, "");
		if(url.endsWith("/")) {
			url=StringUtils.removeEnd(url, "/");
		}
		String dirPath=basePath+"/"+url;
		File dir=new File(dirPath);
		dir.mkdirs();
		String filePath=dirPath+"/"+"index.html";
		File html=new File(filePath);
		FileUtils.writeStringToFile(html, content, "UTF-8");  
	}
	
	/**
	 * 从网页中解析出所有link中href的内容
	 */
	protected Set<String> readLinks(String content) {
		Set<String> urls=new HashSet<String>();
		String linksRegexString="<a\\s+(?:[^>]*?\\s+)?href=\"([^\"]*)\"";
		String hrefRegexString="href\\s*=\\s*\".*\"";
		Pattern linksPattern=Pattern.compile(linksRegexString);
		Pattern hrefPattern=Pattern.compile(hrefRegexString);
		Matcher linksMatcher=linksPattern.matcher(content);
		while(linksMatcher.find()) {
			String link=linksMatcher.group();
			Matcher hrefMatcher=hrefPattern.matcher(link);
			if(hrefMatcher.find()) {
				String url=hrefMatcher.group();
				url=url.replaceAll("(href)|(=)|(\\s)|\"", "");
				urls.add(url);
			}
		}
		return urls;
	}
	
	/**
	 * 处理row links，并对比查找其中未解析的网址进行解析。
	 * 通过一个set保存已经解析过的网址。
	 * @param links
	 * @return
	 */
	protected Set<String> getUnresolvedLinks(Set<String> links) {
		Set<String> unsolvedLinks=new HashSet<String>();
		for (String rawLink : links) {
			if(isOurs(rawLink)) {
				String link=pure(rawLink);
				if(!solvedLinks.contains(link)) {
					unsolvedLinks.add(link);
					solvedLinks.add(link);
				}
			}
		}
		return unsolvedLinks;
	}
	
	/**
	 * 判断是否是指定网站的路径
	 * @param url
	 * @return
	 */
	protected boolean isOurs(String url) {
		return url.startsWith("/");
	}
	/**
	 * 动态网站会生成带";"的url，有些带？的连接也是我们不需要的
	 * @param url
	 * @return
	 */
	protected String pure(String url) {
		for (String separator : separators) {
			url=StringUtils.substringBefore(url, separator);
		}
		url=url.trim();
		return url;
	}	
	
	/**
	 * 读取link内容，在对应位置生成相应html页面，
	 * @param url
	 * @return
	 */
	protected String resolveLink(String url) {
		return HtmlGenerator.generate(url);
	}
	
	public static void main(String[] args) {
		StaticWebsiteGenerator generator=new StaticWebsiteGenerator();
		generator.basePath="E://StaticWebsite";
		generator.resolve("http://localhost:8080","http://localhost:8080/hillhouse/");
		for (String link : generator.solvedLinks) {
			System.out.println(link);
		}
	}
}
