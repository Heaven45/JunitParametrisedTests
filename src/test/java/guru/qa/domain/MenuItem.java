package guru.qa.domain;

public enum MenuItem {

    HOUSE("Бытовая техника"),
    SMARTPHONES("Смартфоны и гаджеты"),
    TV("ТВ и мультимедиа"),
    COMPUTERS("Компьютеры"),
    OFFICE("Офис и сеть");

    private String description;

    MenuItem(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}
