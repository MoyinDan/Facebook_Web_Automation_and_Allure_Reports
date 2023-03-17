import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    //import the selenium webDriver
    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1.Open your Chrome browser
        driver = new ChromeDriver(options);
        //Test1.Verify the user input the right url and its on the right webpage
        //2.Input your selenium demo page url (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com");
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("Correct Webpage URL");
        else
            //fail
            System.out.println("Wrong Webpage URL");
        Thread.sleep(5000);
        //3.Maximize the browser
        driver.manage().window().maximize();
        //4.Click on Signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    }


    @Test(priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test7.Verify that user is successfully sign up when valid details are inputed
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("mary4444");
        //6.Input you Email on the Email field
        driver.findElement(By.id("user_email")).sendKeys("mary4444@millinator.com");
        //7.Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8.Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void clickMeaghanItem() throws InterruptedException {
        // 9.Click on the meaghan item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test2.Verify that when user click on the signup button, the user is directed to the signup page
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Signup Url");
        else
            //faIl
            System.out.println("Wrong Signup Url");
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void verifyItem() {
        //Test9.Verify that an item (03/08/2023) is present
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        //Test8.Verify that (03/08/2023) item is present on the meaghan page
        String actualPageUrl = driver.getCurrentUrl();
        String expectedPageUrl = "/articles/1";
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct Page Url");
        else
            //fail
            System.out.println("Wrong Page Url");

    }

    @Test(priority = 3)
    public void logoutSuccessfully() {
        //11.Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10.Verify that when the user logout he/she is directed back to the login page
        String actualTitlePage = driver.getTitle();
        String expectedTitlePage = "AlphaBlog";
        if (actualTitlePage.contains(expectedTitlePage))
            //pass
            System.out.println("Correct Title Page");
        else
            //fail
            System.out.println("Wrong Title Page");
    }

    @Test(priority = 4)
    public void negativeSignup() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Test3.Verify that user cannot sign up with username less than 3 character
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("ma");
        //6.Input you Email on the Email field
        driver.findElement(By.id("user_email")).sendKeys("mary10@millinator.com");
        //7.Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8.Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void negativeSignupWrongEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        //Test3.Verify that user cannot sign up with username less than 3 character
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("mary3");
        //6.Input you Email on the Email field
        //4.Verify user cannot sign up with invalid email address
        driver.findElement(By.id("user_email")).sendKeys("mary10millinator.com");
        //7.Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8.Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void negativeSignupWrongPassword() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        //5.Verify user cannot login with password less than or equal to one character
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("allaade");
        //6.Input you Email on the Email field
        //4.Verify user cannot sign up with invalid email address
        driver.findElement(By.id("user_email")).sendKeys("mary17@millinator.com");
        //7.Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("");
        //8.Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void negativeSignupWithBlankUsernameAndEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        //Test3.Verify that user cannot sign up with username less than 3 character
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //6.Input you Email on the Email field
        //4.Verify user cannot sign up with invalid email address
        driver.findElement(By.id("user_email")).sendKeys("");
        //7.Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8.Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void negativeSignInWithInvalidEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        //6.Input you Email on the Email field
        //4.Verify user cannot sign in with invalid email address

        driver.findElement(By.id("session_email")).sendKeys("adeja@mailnator.com");
        //7.Input your password on the password field
        driver.findElement(By.id("session_password")).sendKeys("admin");
        //8.Click on the signIn button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 9)
    public void negativeSignInWithInvalidPassword() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        //6.Input you Email on the Email field
        //4.Verify user cannot sign in with invalid password
        driver.findElement(By.id("session_email")).sendKeys("aladeja@mailnator.com");
        //7.Input your password on the password field
        driver.findElement(By.id("session_password")).sendKeys("min");
        //8.Click on the signIn button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 10)
    public void positiveSignIn() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        //6.Input you Email on the Email field
        //4.Verify user can sign in with valid email and password
        driver.findElement(By.id("session_email")).sendKeys("aladeja@mailnator.com");
        //7.Input your password on the password field
        driver.findElement(By.id("session_password")).sendKeys("admin");
        //8.Click on the signIn button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        //Quit the driver
        driver.quit();
    }


}
