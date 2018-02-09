package enums;

import java.util.Objects;

public enum MenuEnum {
    HOME,
    CONTACT_FORM,
    SERVICE(2), // <- TODO as far as i understand, SERVICE is the first level of the menu...
    METALS_COLORS("Metals & Colors");

    private String title;
    private int level;

    // TODO lombok ?
    MenuEnum() {
    }

    MenuEnum(String title) {
        this.title = title;
    }

    MenuEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        if (Objects.isNull(title)) {
            return name().replaceAll("_", " ");
        } else {
            return title;
        }
    }
}
