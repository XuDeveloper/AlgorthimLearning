package com.xu.string;

import java.util.HashSet;

public class Unique_Email_Addresses_929 {

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        for (String email: emails) {
            String[] arr = email.split("@");
            String local = arr[0];
            int index = local.indexOf('+');
            if (index >= 0) {
                local = local.substring(0, index);
            }
            local = local.replaceAll("\\.", "");
            set.add(local + "@" + arr[1]);
        }
        return set.size();
    }

}
