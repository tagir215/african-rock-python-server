package com.tiger.designPatterns200.service.webscraping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 
 * @author OMISTAJA
 * scraper for pc-builder.io. can scrape individual products, a page of products or compatible products 
 * pages of given urls.
 */
public class SeleniumScraper {
	private WebDriver driver;
	private HashMap<String,HashMap<String,Object>>scrapedProducts = new HashMap<>();
	private long id = 1;
	private final String BASEURL = "https://pc-builder.io/";
	private List<Long>compatibleIds = new ArrayList<>();
	
	/**
	 * 
	 */
	public SeleniumScraper() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMISTAJA\\Desktop\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)");
		driver = new ChromeDriver(options);
	}
	
	
	/**
	 * @param url
	 * @param depth
	 * @return
	 */
	public HashMap<String,HashMap<String,Object>>createProductMap(String url, int depth) {
		HashMap<String,HashMap<String,Object>>productMap = new HashMap<>();
		driver.get(url);
		wait2();
		List<WebElement>links = scrapeProductLinks();
		List<Double>prices = scrapePrices();
		
		
		List<String>hrefs = new ArrayList<>();
		List<String>names = new ArrayList<>();
		for(WebElement link : links) {
			hrefs.add(link.getAttribute("href"));
			names.add(link.getText());
		}
		
		int targetDepth = hrefs.size() < depth ? hrefs.size() : depth;
		
		for(int i=0; i<targetDepth; i++) {
			String href = hrefs.get(i);
			
			
			if(scrapedProducts.get(href)==null) {
				double price = prices.get(i);
				HashMap<String,Object>objectMap = scrapeProduct(href,id,price);
				compatibleIds.add(id);
				scrapedProducts.put(href, objectMap);
				productMap.put(names.get(i),objectMap);
				id++;	
			}else {
				compatibleIds.add((Long) scrapedProducts.get(href).get("id"));
			}
			
			
			
			System.out.println((i+1)+"/"+targetDepth);
		}
		
		return productMap;
	}
	
	/**
	 * @return
	 */
	private List<Double>scrapePrices(){
		List<WebElement>elements = driver.findElements(By.className("price-box"));
		List<Double>prices = new ArrayList<>();
		for(WebElement e : elements) {
			WebElement p = e.findElement(By.tagName("p"));
			String price = p.getText().replaceAll("[^0-9,.]", "");
			prices.add(Double.parseDouble(price));
		}
		return prices;
	}
	
	/**
	 * @return
	 */
	private List<WebElement>scrapeProductLinks(){
		List<WebElement>elements = driver.findElements(By.cssSelector(".d-flex.flex-column"));
		List<WebElement>links = new ArrayList<>();
		for(WebElement e : elements) {
			WebElement link = e.findElement(By.tagName("a"));
			String href = link.getAttribute("href");
			if(href.startsWith(BASEURL)) {
				links.add(link);	
			}
		}
		System.out.println(links.size()+" links found");
		return links;
	}

	/**
	 * @param url
	 * @param id
	 * @param price
	 * @return
	 */
	public HashMap<String,Object> scrapeProduct(String url,Long id,double price) {
	
		driver.get(url);
		wait2();
		List<WebElement>productNames = driver.findElements(By.className("product-name"));
		List<WebElement>variantBoxes = driver.findElements(By.className("spec-variant-box"));
		String name = productNames.get(0).getText();
		HashMap<String,List<String>>variantMap = getVariantMap(variantBoxes);
		HashMap<String,Object>map = SeleniumJsonMapper.generatePart(id,name,price,url, variantMap);
		return map;
	}
	
	/**
	 * @param variantBoxes
	 * @return
	 */
	private HashMap<String,List<String>>getVariantMap(List<WebElement>variantBoxes) {
		HashMap<String,List<String>>variantMap = new HashMap<>();
		for(WebElement e : variantBoxes) {
			List<WebElement>spans = e.findElements(By.tagName("span"));
			if(spans.size()<2) {
				continue;
			}
			String key = spans.get(0).getText();
			List<String>variants = new ArrayList<>();
			getElementRecursive(spans.get(1),variants);
			variantMap.put(key, variants);
		}
		return variantMap;
	}
	
	/**
	 * @param e
	 * @param list
	 */
	private void getElementRecursive(WebElement e,List<String>list) {
		List<WebElement> childElements = e.findElements(By.xpath(".//*"));
		if(childElements==null || childElements.size()==0) {
			list.add(e.getText());
		}else {
			childElements = e.findElements(By.xpath(".//*"));
			for(WebElement child : childElements) {
				getElementRecursive(child,list);
			}
		}
	}
	
	/**
	 * @param linkText
	 * @return
	 */
	private String getLinkByText(String linkText) {
		WebElement link = driver.findElement(By.linkText(linkText));
		return link.getAttribute("href");
	}
	
	/**
	 * 
	 * @param resultMap  creates data that parentMap is going to reference
	 * @param parentMap	 adds compatibility info to the parentMap
	 * @param linkText   link that the scraper is going to use this iteration
	 * @param depth		 how many products it will at maximum scrape at every compatibility page
	 * 
	 */
	public void compatibleProductsSuperviser(HashMap<String,HashMap<String,Object>>resultMap, 
			HashMap<String,HashMap<String,Object>>parentMap, String linkText, int depth) 
	{
		List<HashMap<String,HashMap<String,Object>>>productMaps = new ArrayList<>();
		int i=1;
		for(String productName : parentMap.keySet()) {
			String href = (String) parentMap.get(productName).get("url");
			driver.get(href);
			wait2();
			String hrefCompatibleParts = getLinkByText(linkText);
			HashMap<String,HashMap<String,Object>>productMap = createProductMap(hrefCompatibleParts,depth);
			
			productMaps.add(productMap);
			
			parentMap.get(productName).put(linkText,compatibleIds);
			compatibleIds = new ArrayList<>();
			System.out.println("parent product "+i+"/"+parentMap.size());
			i++;
		}
		for(HashMap<String,HashMap<String,Object>>productMap : productMaps) {
			resultMap.putAll(productMap);
		}
		
	}
	
	
	/**
	 * 
	 */
	private void wait2() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
