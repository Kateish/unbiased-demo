package uk.co.unbiased.demo.tests;

import org.junit.jupiter.api.Test;
import uk.co.unbiased.demo.pages.SearchAdviserPage;

public class SearchAdviserTests extends TestBase{
    SearchAdviserPage searchAdviserPage;
    @Test
    public void successfulSearchTest() {
        searchAdviserPage = new SearchAdviserPage();
        searchAdviserPage.openPage();
        searchAdviserPage.fillSearchData();
        searchAdviserPage.checkSearchResults();
    }
}
