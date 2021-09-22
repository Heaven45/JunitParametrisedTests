package guru.qa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DnsMainPage {


    public DnsMainPage openMainPage() {
        open("https://www.dns-shop.ru/");
        return this;
    }

    public DnsMainPage choseTab(String tabName) {
        $$(byText(tabName)).first().click();
        return this;
    }

    public DnsMainPage checkTabName(String tabName) {
        $("span[itemprop='item']").shouldHave(text(tabName));
        return this;
    }

    public DnsMainPage clickItemWithNumber(int number) {
        $(".menu-desktop__root-title", number).click();
        return this;
    }
}
