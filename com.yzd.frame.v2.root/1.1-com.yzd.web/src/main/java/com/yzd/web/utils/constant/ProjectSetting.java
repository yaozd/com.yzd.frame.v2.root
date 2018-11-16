package com.yzd.web.utils.constant;

import java.util.ResourceBundle;

public class ProjectSetting {
    private static final String DEFAULT_PROJECT_PROPERTIES ="project" ;
    private static ResourceBundle PROJECT_CONFIG = ResourceBundle.getBundle(DEFAULT_PROJECT_PROPERTIES);
    public static String getConfigProperty(String key) {
        return PROJECT_CONFIG.getString(key);
    }

}