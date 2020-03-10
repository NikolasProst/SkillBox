package main.enums;

public enum PostViewMode {
    RECENT("recent"),
    POPULAR("popular"),
    BEST("best"),
    EARLY("early");

    private final String name;

    PostViewMode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PostViewMode getByName(String name) {
        for (PostViewMode mode : PostViewMode.values()) {
            if (name.toLowerCase().equals(mode.getName().toLowerCase())) {
                return mode;
            }
        }
        throw new IllegalArgumentException();
    }
}
