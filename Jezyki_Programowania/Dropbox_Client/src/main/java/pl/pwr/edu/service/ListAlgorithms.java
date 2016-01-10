package pl.pwr.edu.service;

import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-01-10.
 */
public class ListAlgorithms {

    public static boolean compareLists(ArrayList<String> first, ArrayList<String> second) {
        if(first.size() != second.size()) return false;

        for(int i = 0; i < first.size(); i++) {
            if( !(first.get(i).equals(second.get(i))) ) return false;
        }

        return true;
    }

}
