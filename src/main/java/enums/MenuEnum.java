package enums;

import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
public enum MenuEnum {
    HOME,
    CONTACT_FORM,
    SERVICE,
    DATES(2),
    METALS_COLORS("Metals & Colors");

    private String title;
    private int level;

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
