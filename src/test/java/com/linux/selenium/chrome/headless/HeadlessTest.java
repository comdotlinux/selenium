package com.linux.selenium.chrome.headless;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static com.linux.CaseInsensitiveSubstringMatcher.containsIgnoringCase;

class HeadlessTest {

	private static final Logger LOG = LoggerFactory.getLogger(HeadlessTest.class);

	private WebDriver headlessWebDriver;

	@BeforeEach
	void setUp() {
		headlessWebDriver = new ChromeDriver(new ChromeOptions().addArguments("window-size=1400x600").addArguments("headless"));
	}

	@AfterEach
	void tearDown() {
		headlessWebDriver.quit();
	}


	@Test()
	@DisplayName("Headless Chrome test")
	protected void chromeHeadlessTest() {
		headlessWebDriver.get("https://www.ikea.com/de/de/");
		String websiteTitle = headlessWebDriver.getTitle();
		assertThat(websiteTitle, containsIgnoringCase("IKEA"));
		LOG.info("Website title {}", websiteTitle);
	}
}
