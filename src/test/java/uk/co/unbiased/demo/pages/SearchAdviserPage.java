package uk.co.unbiased.demo.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchAdviserPage {
    String adviser = "Financial adviser";
    String adviceOn = "Financial planning";
    String income = "£10,000,000+";
    String postCode = "SE207AA";
    String targetAdviser = "The Private Office";

    public void openPage() {
        open("https://www.unbiased.co.uk");
        $(By.linkText("Ok, thanks")).click();
    }

    public SearchAdviserPage fillSearchData() {
        $(By.cssSelector(".financial")).click();
        $(By.linkText("Show me a list")).click();
        $(byText(this.adviser)).click();
        $(byText(this.adviceOn)).click();
        $(byText(this.income)).click();
        $(By.id("input-60")).setValue(this.postCode).submit();
        $(byText("Find advisers")).click();
        return this;
    }

    public void checkSearchResults() {
        $$(By.xpath("//*[@class='row flex-nowrap no-gutters']")).filterBy(Condition.text(this.targetAdviser)).shouldHaveSize(0);
        $$(By.xpath("//*[@class='row flex-nowrap no-gutters']")).shouldHaveSize(20);
    }
}
