package uk.co.unbiased.demo.pages;

import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchAdviserPage {
    String adviser = "Financial adviser";
    String adviceOn = "Financial planning";
    String income10MSelector = "#list-item-176-8 .v-list-item__title";
    String postCode = "SE207AA";
    String targetAdviser = "The Private Office";

    public void openPage() {
        open("https://www.unbiased.co.uk");
        $(By.linkText("Ok, thanks")).click();
    }

    public SearchAdviserPage fillSearchData() {
        $(By.cssSelector(".financial")).click();
        $(By.linkText("Show me a list")).click();
        $(byText(adviser)).click();
        $(byText(adviceOn)).click();
        $(income10MSelector).click();
        $(By.id("input-60")).setValue(postCode).submit();
        $(byText("Find advisers")).click();
        return this;
    }

    public void checkSearchResults() {
        $$(By.xpath("//*[@class='row flex-nowrap no-gutters']")).filterBy(text(targetAdviser)).shouldHaveSize(0);
        $$(By.xpath("//*[@class='row flex-nowrap no-gutters']")).shouldHaveSize(20);
    }
}
