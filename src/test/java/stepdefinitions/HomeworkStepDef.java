package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.PaymentPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeworkStepDef {

    DefaultPage defaultPage = new DefaultPage();
    PaymentPage paymentPage = new PaymentPage();
    Actions actions = new Actions(Driver.getDriver());

    @When("user selects a {string}")
    public void user_selects_a(String car) {
        Driver.waitForVisibility(defaultPage.select_car, 3);
        Select select = new Select(defaultPage.select_car);
        select.selectByVisibleText(car);
    }

    @When("user enters pick up place {string}")
    public void user_enters_pick_up_place(String place) {
        Driver.waitForVisibility(defaultPage.pick_place, 3);
        Driver.waitAndSendText(defaultPage.pick_place, place);
    }

    @When("user enters drop off place {string}")
    public void user_enters_drop_off_place(String string) {

        Driver.waitAndSendText(defaultPage.drop_place, string);
    }

    @When("user enters pick up date {string}")
    public void user_enters_pick_up_date(String string) {
        Driver.waitAndSendText(defaultPage.pick_date, string);
    }

    @When("user enters pick up time {string}")
    public void user_enters_pick_up_time(String string) {
        Driver.waitAndSendText(defaultPage.pick_time, string);
//   both of them are OK
//        defaultPage.pick_time.sendKeys(string);
    }

    @When("user enters drop off date {string}")
    public void user_enters_drop_off_date(String string) {
        Driver.waitAndSendText(defaultPage.drop_date, string);
    }


    @When("user enters drop off time {string}")
    public void user_enters_drop_off_time(String string) {
        Driver.waitAndSendText(defaultPage.drop_time, string);
    }

    @Then("user clicks on continue reservation")
    public void user_clicks_on_continue_reservation() {
//       defaultPage.continueReservationButton.click();
        Driver.waitAndClick(defaultPage.continueReservationButton);
    }

    @Then("verify complete reservation screen pop up")
    public void verify_complete_reservation_screen_pop_up() {
        Driver.waitForVisibility(paymentPage.completeReservation, 3);
        Assert.assertTrue(paymentPage.completeReservation.isDisplayed());
    }

    @Then("user enters card number {string}")
    public void user_enters_card_number(String string) {
        ReusableMethods.waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(paymentPage.cardNumber).click().sendKeys(Keys.HOME).sendKeys(string).build().perform();
    }

    @Then("user enters {string} on the card")
    public void user_enters_on_the_card(String string) {
        Driver.waitAndSendText(paymentPage.cardName, string);
    }

    //                  expire_date  CVC
    @Then("user enters {string} and {string}")
    public void user_enters_and(String expire_date, String CVC) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(paymentPage.expireDate).click().sendKeys(Keys.HOME).sendKeys(expire_date).build().perform();
        actions.moveToElement(paymentPage.CVC).click().sendKeys(Keys.HOME).sendKeys(CVC).build().perform();
    }

    @Then("user checks the agreement")
    public void user_checks_the_agreement() {
        Driver.waitAndClick(paymentPage.contractCheckbox);
    }

    @Then("user clicks complete reservation")
    public void user_clicks_complete_reservation() {
        Driver.waitAndClick(paymentPage.completeReservation2);
    }

    @Then("verify Reservation created successfully pop up")
    public void verify_reservation_created_successfully_pop_up() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(paymentPage.reservationSuccessfulMsgAlert.isDisplayed());

    }

    @Then("naviaged to Reservations secreen")
    public void naviaged_to_reservations_secreen() {
        ReusableMethods.waitFor(10);
        Driver.waitForVisibility(defaultPage.loginButtonDropdown, 10);
        Driver.waitAndClick(defaultPage.loginButtonDropdown);
        Driver.waitAndClick(defaultPage.reservationSelect);

//        Select select = new Select(defaultPage.loginButtonDropdown);
//      //  select.selectByVisibleText("Reservations");
//        select.selectByIndex(0);
    }

    @And("verify the last reservation is created {string} {string} {string}")
    public void verifyTheLastReservationIsCreated(String car, String pickPlace, String dropPlace) {
        //    | car         | pick_place | drop_place | pick_date  | pick_time | drop_date  | drop_time |  name    |
//            | Honda Civic | Mersin     | Anamur     | 09/09/2076 | 01:00PM   | 09/09/2077 | 08:00AM   |  Ali Can |
        //  Driver.waitForVisibility(defaultPage.reservedStatus.get(defaultPage.reservedStatus.size() - 1), 3);
        ReusableMethods.waitFor(5);
        List<WebElement> reservedCarNames = defaultPage.reservedCarListCarNames;
        List<WebElement> reservedPickPlace = defaultPage.reservedPickPlace;
        List<WebElement> reservedDropPlace = defaultPage.reservedDropPlace;
        List<WebElement> reservedStatus = defaultPage.reservedStatus;

        Driver.waitForVisibility(defaultPage.reservationScrolldown, 10);
        // actions.moveToElement(defaultPage.reservationScrolldown).perform();
        Driver.executeJScommand(defaultPage.reservationScrolldown, "arguments[0].scrollIntoView(true);");

        String actualCar = reservedCarNames.get(reservedCarNames.size() - 1).getText();
        String actualpickPlace = reservedPickPlace.get(reservedPickPlace.size() - 1).getText();
        String actualdropPlace = reservedDropPlace.get(reservedDropPlace.size() - 1).getText();
        System.out.println(actualCar + " " + " " + actualpickPlace + " " + " " + actualdropPlace);

        Driver.waitForVisibility(reservedCarNames.get(reservedCarNames.size() - 1), 3);
        Assert.assertEquals(car, actualCar);

        Driver.waitForVisibility(reservedPickPlace.get(reservedPickPlace.size() - 1), 3);
        Assert.assertTrue(actualpickPlace.contains(pickPlace));

        Driver.waitForVisibility(reservedDropPlace.get(reservedDropPlace.size() - 1), 3);
        Assert.assertTrue(actualdropPlace.contains(dropPlace));

        Driver.waitForVisibility(reservedStatus.get(reservedStatus.size() - 1), 3);
        Assert.assertTrue(reservedStatus.get(reservedStatus.size() - 1).isDisplayed());
    }

    @When("you click on the last reservation")
    public void you_click_on_the_last_reservation() {
        Driver.waitForVisibility(defaultPage.reservedTableRows.get(defaultPage.reservedTableRows.size() - 1), 3);

        actions.moveToElement(defaultPage.reservedTableRows.get(defaultPage.reservedTableRows.size() - 1)).perform();
        Driver.wait(1);
        actions.click(defaultPage.reservedTableRows.get(defaultPage.reservedTableRows.size() - 1)).perform();

    }

    @Then("verify reservation detail page is displayed")
    public void verify_reservation_detail_page_is_displayed() {
        Driver.waitForVisibility(defaultPage.reservationDetailPage, 3);
        Assert.assertTrue(defaultPage.reservationDetailPage.isDisplayed());

    }

    @Then("verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age")
    public void verify_the_table_has_the_following_fields_model_doors_seats_luggage_transmission_air_conditioning_fuel_type_age() {
        Driver.waitForVisibility(defaultPage.carDetails, 3);
        List<WebElement> carDetailTable = defaultPage.carDetailRowsColumn1;
        List<String> verifyCarTable = new ArrayList<>(Arrays.asList("Model", "Doors", "Seats", "Luggage", "Transmission", "Air Conditioning", "Fuel Type", "Age"));
        if (!carDetailTable.get(0).isDisplayed()) {
            actions.click(defaultPage.carDetails).perform();
        }
        for (int i = 0; i < carDetailTable.size(); i++) {
            Driver.waitForVisibility(carDetailTable.get(i), 3);
            Assert.assertTrue(carDetailTable.get(i).getText().contains(verifyCarTable.get(i)));
        }

    }

    @Then("click click on back to reservations")
    public void click_click_on_back_to_reservations() {
        Driver.waitForVisibility(defaultPage.backToReservationsButton, 3);
        actions.click(defaultPage.backToReservationsButton).perform();

    }

    @Then("verify Reservation page is displayed")
    public void verify_reservation_page_is_displayed() {
        Driver.waitForVisibility(defaultPage.reservationsPage, 3);
        Assert.assertTrue(defaultPage.reservationsPage.isDisplayed());
    }

    @Then("click on Home link")
    public void click_on_home_link() {
        Driver.waitForVisibility(defaultPage.homelink, 3);
        actions.click(defaultPage.homelink).perform();
    }

    @Then("verify the homepage is displayed")
    public void verify_the_homepage_is_displayed() {
        Driver.wait(1);
        Assert.assertEquals("https://www.bluerentalcars.com/", Driver.getDriver().getCurrentUrl());
    }
}