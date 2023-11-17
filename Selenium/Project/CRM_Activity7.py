# Import webdriver from selenium
import time
from threading import Thread

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.color import Color
from selenium.webdriver import ActionChains
from selenium.webdriver.support.ui import WebDriverWait

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Set up the Firefox Driver with WebDriverManger
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    wait = WebDriverWait(driver, 10)
    driver.get("https://alchemy.hguy.co/crm")
    driver.find_element(By.ID, "user_name").send_keys("admin")
    driver.find_element(By.ID, "username_password").send_keys("pa$$w0rd")

    driver.find_element(By.ID, "bigbutton").click()
    time.sleep(10)

    actions = ActionChains(driver)
    driver.find_element(By.ID, "grouptab_0").click()

    time.sleep(10)
    driver.find_element(By.ID, "moduleTab_9_Leads").click()
    time.sleep(20)
    driver.find_element(By.XPATH, "//span[@class='suitepicon suitepicon-action-info'][1]").click()
    time.sleep(20)
    phnNumber = driver.find_element(By.XPATH, " //span[@class='phone']").text
    print("PhoneNumber: ", phnNumber)
    driver.quit()
