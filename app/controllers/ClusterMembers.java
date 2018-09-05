package controllers;

import java.util.*;
/**
 * Created by M1039838 on 9/5/2018.
 */
public class ClusterMembers {

    private static Map<String, String> members = new HashMap<String, String>();

    public static void set(String role, String host) {
        members.put(role, host);
    }

    public static String get(String role) {
        return members.get(role);
    }
}
