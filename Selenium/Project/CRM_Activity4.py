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

    driver.get("https://alchemy.hguy.co/crm")

    driver.find_element(By.ID, "user_name").send_keys("admin")
    driver.find_element(By.ID, "username_password").send_keys("pa$$w0rd")

    driver.find_element(By.ID, "bigbutton").click()
    driver.implicitly_wait(20)

    Homepagetext = driver.find_element(By.ID, "tab0")

    print("SUITECRM DASHBOARD: ", Homepagetext.text)


    driver.quit()
