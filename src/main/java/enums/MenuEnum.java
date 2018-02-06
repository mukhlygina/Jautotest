package enums;

public enum MenuEnum {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    public String title;

    MenuEnum(String title) {
        this.title = title;
    }
}
