package com.qaprosoft.carina.demo.enums;

public enum MenuItem {
    CATALOG("Catalog"),
    WEBVIEW("Web"),
    QRCODE("Qr"),
    GEO("Geo"),
    DRAWING("Drawing"),
    ABOUT("About"),
    RESET("Reset"),
    FINGER("Finger"),
    FACEID("Face"),
    REPORT_BUG("Report a Bug"),
    REPORT_DEBUG("Report a Bug(debug)"),
    CRASH_APP("Crash"),
    LOGIN("Log");

    private String menu;

    MenuItem(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }
}
