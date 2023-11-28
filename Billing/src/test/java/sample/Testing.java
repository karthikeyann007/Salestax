package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.DependencyMap;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Testing {
	WebDriver driver;
	private String invoicenumber;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.1.210:9100/");

	}

	@Test(priority = 1)    

	public void Login() throws InterruptedException {
		long timeoutInSeconds = 20;
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		System.out.println("hii");
		WebElement Username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-login[1]/div/div/div/div[2]/div/form/div[1]/span[1]/input")));
		WebElement Password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-login[1]/div/div/div/div[2]/div/form/div[2]/span[1]/input")));
		
		Username.sendKeys("Hetall");
		Password.sendKeys("Hets@505866!");
		WebElement Login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-login[1]/div/div/div/div[2]/div/form/div[3]/button")));
		Login.click();
	}
	@Test(priority = 2)
	public void Userscreen() throws InterruptedException {
		long timeoutInSeconds = 20;
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

		WebElement User_screen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-left-menu/div[1]/div[2]/div/div[1]/div/a[4]")));
		User_screen.click();
		
		WebElement User = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-left-menu/div[2]/div[2]/div[3]/div/p-menu/div/ul/li[2]/a/span")));
		User.click();

		WebElement userTable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-v-user/div/div/div")));
       List<WebElement> userTableHeader = userTable.findElements(By.tagName("th"));
        
        for (WebElement tableHead : userTableHeader) {
            String userTableHead = tableHead.getText();
            System.out.println(userTableHead);
        }

        List<WebElement> userNameList = userTable.findElements(By.cssSelector("tbody tr"));
        int size = userNameList.size();
        System.out.println("Number of rows: " + size);

        for (int i=0; i<=size; i++) {
            List<WebElement> row = userNameList.get(i).findElements(By.tagName("td"));
            WebElement firstColumn = row.get(1);
            
            
            String firstColumnText = firstColumn.getText();
            System.out.println("name is:"+firstColumnText);
            
            if (firstColumnText.equals("Yaseen")) { 
            	System.out.println("condition is True");
            	WebElement action = row.get(0);
            	String actions = action.getText();
            	System.out.println("action"+actions);
            	WebElement editButton = action.findElement(By.xpath("//button[@title='Edit' and contains(@class, 'p-button-success')]"));       		
            	editButton.click();
            	break;
	        }
		}
	}
}
		
		
		
	
		
		
		/*WebElement User_searchbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-v-user/div/div/div/form/div/div/p-toolbar/div/div[1]/span/input")));
		User_searchbox.click();
		User_searchbox.sendKeys("Hetall");
		
		WebElement editbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-v-user/div/div/div/form/div/div/p-table/div/div/table/tbody/tr[2]/td[1]/button[2]")));
		editbutton.click();*/

	

	/*@Test(priority = 2)
	public void salestax() throws InterruptedException {
		long timeoutInSeconds = 20;
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		
		WebElement sales_tax_screen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-left-menu/div[1]/div[2]/div/div[1]/div/a[9]/i")));
		sales_tax_screen.click();
		
		WebElement sales_tax_invoice= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-left-menu/div[2]/div[2]/div[9]/div/p-menu/div/ul/li[3]/a")));
		sales_tax_invoice.click();
		
		WebElement salestaxcreate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-v-salesinvoicetax/div/div/div/div[1]/div/div[2]/div/button/span[1]")));
		salestaxcreate.click();
		
		WebElement customername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/form[1]/table/tr[1]/td[3]/div/span/p-dropdown/div")));
		customername.click();
		
		WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/form[1]/table/tr[1]/td[3]/div/span/p-dropdown/div/div[3]/div[1]/div/input")));
		optionToSelect.sendKeys(new CharSequence[] { "CHOUHAN BROTHER" });
		optionToSelect.sendKeys(new CharSequence[] {Keys.ARROW_DOWN,Keys.ENTER});   
		WebElement select_branch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/form[1]/table/tr[2]/td[3]/span/p-dropdown/div/span")));
		select_branch.click();
		
		
		WebElement select_branch_name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/form[1]/table/tr[2]/td[3]/span/p-dropdown/div/div[3]/div/ul/p-dropdownitem[2]/li/span")));
		select_branch_name.click();
		
		
		String[] productNames = {"ADAPTOR VSP FEMALE 40 x 1 1/4\" M786"}; 
		
				
		for (int i = 0; i < productNames.length; i++)
		{
			Thread.sleep(1000);
			String productName = productNames[i];

			WebElement productnamesearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/form[2]/table/tr[2]/td[3]/span/p-autocomplete/span/input")));
			productnamesearch.click();

			//productnamesearch.clear();
			productnamesearch.sendKeys(new CharSequence[] {productName});
			Thread.sleep(1000);
			productnamesearch.sendKeys(new CharSequence[] {Keys.ARROW_DOWN,Keys.ENTER});
			

			WebElement quantity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/form[2]/table/tr[3]/td[1]/span/input")));
			quantity.click();
			quantity.sendKeys(new CharSequence[] { "2" });


			WebElement addquantity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/form[2]/table/tr[4]/td[1]/button[1]")));
			addquantity.click();
			
			
			WebElement discount_apply = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/div[2]/p-table/div/div/table/tbody/tr/td[10]")));
			discount_apply.click();
			
			WebElement discount_value = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/div/p-tabpanel[1]/div/div[2]/p-table/div/div/table/tbody/tr/td[10]/p-celleditor/input")));
			discount_value.sendKeys("1");
			
		}
		

		WebElement payables = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[2]/p-tabview/div/ul/li[2]/a/span")));
		payables.click();	
		
		WebElement paid = wait.until(ExpectedConditions.elementToBeClickable(By.name("balanceamount")));
		String amountToEnter =  paid.getAttribute("value");
		String positiveAmount = amountToEnter.replace("-", "");
		System.out.println("amountToEnter: " + positiveAmount);

		WebElement paid_amounts = wait.until(ExpectedConditions.elementToBeClickable(By.name("cuscurrencyamount1")));
		paid_amounts.click();
		paid_amounts.sendKeys(new CharSequence[] {positiveAmount});
		WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[1]/div/div[2]/div/button[1]")));
		savebutton.click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		System.out.println(driver.getCurrentUrl());
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.close();
		driver.switchTo().window(list.get(0));
		Thread.sleep(4000);
		WebElement discount_approval = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-header/p-dialog[1]/div/div/div[3]/p-footer/div/div/button[1]")));
		discount_approval.click();
		
		WebElement search_screen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-salesinvoicetax/div/div/div/div[1]/div/div[2]/div/button[5]")));
		search_screen.click();
		WebElement select_invoice_no = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-v-salesinvoicetax/div/div/div/div[2]/div/p-table/div/div/table/tbody/tr[1]/td[2]")));
		invoicenumber = select_invoice_no.getText();
		System.out.println("invoicenumber:"+invoicenumber);




	}
	@ Test(priority = 3)
	public void stockdelivery() throws InterruptedException
	{			
		long timeoutInSeconds = 20;
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		
		WebElement change_branch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-header/header/div/div/div[1]/form/div[1]/p-dropdown/div/span")));
		change_branch.click();
		WebElement change_branch_name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-header/header/div/div/div[1]/form/div[1]/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[2]/li/span")));
		change_branch_name.click();
		
		
		WebElement delivery = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-left-menu/div[1]/div[2]/div/div[1]/div/a[7]")));
		delivery.click();
		
		WebElement stockdelivery = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-left-menu/div[2]/div[2]/div[7]/div/p-menu/div/ul/li[3]/a/span")));
		stockdelivery.click();
		
		WebElement stockdelivery_create = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-v-stockdelivery/div/div/div/div[1]/div/div[2]/div/button/span[1]")));
		stockdelivery_create.click();
		
		Thread.sleep(4000);
		WebElement stockdelivery_Ref = wait.until(ExpectedConditions.elementToBeClickable(By.name("_evidenceno")));
		stockdelivery_Ref.click();
		Thread.sleep(1000);
		WebElement stockdelivery_Ref_list = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/div/div[2]/table/tr[2]/td[1]/form/span/p-multiselect/div/div[4]/div[1]/div[2]/input")));
		stockdelivery_Ref_list.click();
		stockdelivery_Ref_list.sendKeys(invoicenumber);
		Thread.sleep(1000);
		WebElement select_invoice_no_checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/div/div[2]/table/tr[2]/td[1]/form/span/p-multiselect/div/div[4]/div[1]/div[1]/div[2]")));
		select_invoice_no_checkbox.click();
		Thread.sleep(1000);

		
		WebElement stockdelivery_Ref_close = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/div/div[2]/table/tr[2]/td[1]/form/span/p-multiselect/div/div[4]/div[1]/button")));
		stockdelivery_Ref_close.click();
		
		WebElement select_all_program_checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/div/div[2]/div[2]/p-table/div/div/table/thead/tr/th[1]/p-tableheadercheckbox/div/div[2]")));
		select_all_program_checkbox.click();
		
		WebElement delivery_quantity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/div/div[2]/div[2]/p-table/div/div/table/tbody/tr[1]/td[11]")));
		delivery_quantity.click();
		
		WebElement delivery_quantitys_product1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/div/div[2]/div[2]/p-table/div/div/table/tbody/tr[1]/td[11]/p-celleditor/input")));
		delivery_quantitys_product1.clear();
		delivery_quantitys_product1.sendKeys(new CharSequence [] {"2"});


		WebElement delivery_save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/div/div[1]/div/div[2]/div/button[1]/span[1]")));
		delivery_save.click();
		WebElement alert_save1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/p-dialog[1]/div/div/div[3]/button[1]")));
		alert_save1.click();
		WebElement alert_save2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-stockdelivery/div/div/p-dialog[2]/div/div/div[3]/button[1]/span[1]")));
		alert_save2.click(); 


	}
	@Test(priority = 4)
	public void Tellercash() throws InterruptedException
	{
		long timeoutInSeconds = 20;
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		
		//LOGOUT
		WebElement Logout_click = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-header/header/div/div/div[2]/ul/li[2]/div/a/img")));
		Logout_click.click();
		WebElement Logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-header/header/div/div/div[2]/ul/li[2]/div/div/ul/li[2]/a")));
		Logout.click();

		//TELLERCASH LOGIN
		
		WebElement Teller_Login_user = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-login[1]/div/div/div/div[2]/div/form/div[1]/span[1]/input")));
		WebElement Teller_Login_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-login[1]/div/div/div/div[2]/div/form/div[2]/span[1]/input")));

		// Send keys to the input field using CharSequence array
		Teller_Login_user.sendKeys(new CharSequence[] { "Arif" });
		Teller_Login_pass.sendKeys(new CharSequence[] { "A786@rif" });
		
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-login[1]/div/div/div/div[2]/div/form/div[3]/button")));
		login.click();
		
		WebElement Tellercash = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-left-menu/div[1]/div[2]/div/div[1]/div/a[10]")));
		Tellercash.click();
		
		WebElement Tellercash_setlement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-left-menu/div[2]/div[2]/div[10]/div/p-menu/div/ul/li[8]/a/span")));
		Tellercash_setlement.click();
		Thread.sleep(8000);
		WebElement Tellercash_setlement_create = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-v-teller-cash-day-settlement/div/div/div/div[1]/div/div[2]/div/button")));
		Tellercash_setlement_create.click();
		Thread.sleep(1000);
		WebElement Teller_name_search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[2]/div[1]/div[1]/form/table/tr[1]/td[2]/span[1]/p-dropdown/div")));
		Teller_name_search.click();
		;
		WebElement Teller_name_select= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[2]/div[1]/div[1]/form/table/tr[1]/td[2]/span[1]/p-dropdown/div/div[3]/div[1]/div/input")));
		Teller_name_select.click();
		Teller_name_select.sendKeys(new CharSequence[] {"Hetall"});
		Teller_name_select.sendKeys(new CharSequence[] {Keys.ARROW_DOWN,Keys.ENTER});

		WebElement Teller_account_name= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[2]/div[1]/div[1]/form/table/tr[1]/td[3]/span[1]/p-dropdown/div")));
		Teller_account_name.click();
		
		WebElement Teller_account_name_search= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[2]/div[1]/div[1]/form/table/tr[1]/td[3]/span/p-dropdown/div/div[3]/div[1]/div/input")));
		Teller_account_name_search.sendKeys(new CharSequence[] {"jaeemm"});
		Teller_account_name_search.sendKeys(new CharSequence[] {Keys.ARROW_DOWN,Keys.ENTER});

		WebElement Teller_search= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[2]/div[1]/div[1]/form/table/tr[3]/td/button[1]/span[2]")));
		Teller_search.click();
		
		WebElement balance_amount= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[2]/div[1]/div[2]/div[2]/p-table/div/div/table/tbody/tr/td[4]")));
		String balance = balance_amount.getText();
		
		System.out.println("balance"+ balance);
		WebElement balance_amount_paid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[2]/div[1]/div[2]/div[2]/p-table/div/div/table/tbody/tr/td[3]")));
		balance_amount_paid.click();
		
		WebElement balance_paid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[2]/div[1]/div[2]/div[2]/p-table/div/div/table/tbody/tr/td[3]/p-celleditor/input")));
		balance_paid.sendKeys(new CharSequence [] {balance});
		
		WebElement Teller_save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[1]/div/div[2]/div/button[1]")));
		Teller_save.click();
		
		WebElement Teller_approval = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/app-root/app-c-teller-cash-day-settlement/div/div/div/div[1]/div/div[2]/div/button[3]/span[1]")));
		Teller_approval.click();
		driver.close();

	}*/
	
	


