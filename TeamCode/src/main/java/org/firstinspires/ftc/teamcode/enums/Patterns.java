package org.firstinspires.ftc.teamcode.enums;

public enum Patterns {
    GPP(21),
    PGP(22),
    PPG(23);

    private final int code;

    Patterns(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Patterns fromCode(int code) {
        for (Patterns pattern : Patterns.values()) {
            if (pattern.getCode() == code) {
                return pattern;
            }
        }
        return null;
    }
}
