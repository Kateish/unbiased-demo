package uk.co.unbiased.demo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class SearchAdviserPage {
    String adviser = "Financial adviser";
    String adviceOn = "Financial planning";
    String income = "£10,000,000+";
    String postCode = "SE207AA";
    String targetAdviser = "The Private Office";

    public SearchAdviserPage() {
    }

    public void openPage() {
        Selenide.open("https://www.unbiased.co.uk");
        Selenide.$(By.linkText("Ok, thanks")).click();
    }

    public SearchAdviserPage fillSearchData() {
        Selenide.$(By.cssSelector(".financial")).click();
        Selenide.$(By.linkText("Show me a list")).click();
        Selenide.$(Selectors.byText(this.adviser)).click();
        Selenide.$(Selectors.byText(this.adviceOn)).click();
        Selenide.$(Selectors.byText(this.income)).click();
        Selenide.$(By.id("input-60")).setValue(this.postCode).submit();
        Selenide.$(Selectors.byText("Find advisers")).click();
        return this;
    }

    public void checkSearchResults() {
        Selenide.$$(By.xpath("//*[@class='row flex-nowrap no-gutters']")).filterBy(Condition.text(this.targetAdviser)).shouldHaveSize(0);
        Selenide.$$(By.xpath("//*[@class='row flex-nowrap no-gutters']")).shouldHaveSize(20);
    }
}
