# Import webdriver from selenium
import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
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
    time.sleep(5)

    driver.find_element(By.ID, "grouptab_0").click()

    time.sleep(5)
    driver.find_element(By.ID, "moduleTab_9_Accounts").click()
    time.sleep(10)



    driver.find_element(By.XPATH,"//h2[@class='module-title-text'][1]")


    for i in [1,3,5,7,9,11]:
        rowdata = driver.find_element(By.XPATH,f"//table/tbody/tr[{i}]/td[3]/b").text
        print(rowdata)
    driver.quit()
