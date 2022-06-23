package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DefaultPage {

    //    After logged in
    public DefaultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement userID;

    @FindBy(linkText = "Logout")
    public WebElement logOut;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK;

    @FindBy(xpath = "//select[@name='car']")
    public WebElement select_car;

    @FindBy(xpath = "//input[@name='pickUpLocation']")
    public WebElement pick_place;

    @FindBy(xpath = "//input[@name='dropOfLocation']")
    public WebElement drop_place;

    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pick_date;

    @FindBy (xpath = "//input[@name='pickUpTime']")
    public WebElement pick_time;

    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement drop_date;

    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement drop_time;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueReservationButton;

    @FindBy (xpath = "//button[@id='dropdown-basic-button']")
    public WebElement loginButtonDropdown;

    @FindBy (xpath = "//table//tbody//tr//td[2]")
    public List<WebElement> reservedCarListCarNames;

    @FindBy (xpath = "//table//tbody//tr//td[3]")
    public List<WebElement> reservedPickPlace;

    @FindBy (xpath = "//table//tbody//tr//td[4]")
    public List<WebElement> reservedDropPlace;

    @FindBy (xpath = "//table//tbody//tr//td[5]")
    public List<WebElement> reservedStatus;

    @FindBy (xpath = "//table//tbody//tr")
    public List<WebElement> reservedTableRows;

    @FindBy(xpath = "//h1")
    public WebElement reservationDetailPage;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement carDetails;

    @FindBy (xpath = "(//table)[2]//tbody//tr//td[1]")
    public List<WebElement> carDetailRowsColumn1;

    @FindBy(xpath = "(//*[.=' Back to reservations'])[2]")
    public WebElement backToReservationsButton;

    @FindBy(xpath = "//h1")
    public WebElement reservationsPage;

    @FindBy(xpath = "(//*[.=' Home'])[1]")
    public WebElement homelink;

    @FindBy(xpath = "//a[@href='/reservations']")
    public WebElement reservationSelect;

    @FindBy (xpath = "(//*[.='Home'])[1]")
    public WebElement reservationScrolldown;









}