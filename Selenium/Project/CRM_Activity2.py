# Import webdriver from selenium

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Set up the Firefox Driver with WebDriverManger
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL

    driver.get("http://alchemy.hguy.co/crm")
    heading = driver.find_element(By.CSS_SELECTOR, "#form > div.companylogo > img").get_attribute("src")
    print("heading of webpage: ", heading)
    driver.quit()