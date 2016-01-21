package pl.pwr.edu.service;

import com.dropbox.core.DbxRequestConfig;

import java.util.Locale;

/**
 * Created by SQUIER on 2016-01-21.
 */
public class TheRockBoxClient {

    public static final com.dropbox.core.DbxClient CLIENT = new com.dropbox.core.DbxClient(new DbxRequestConfig("dbClient",
            Locale.getDefault().toString()),
            "EvkCZHVLfmAAAAAAAAAAM4gVyl3yXkA6i6wfEDGW_cLNVDbiSzzTbWUq9t3QUGlB");

}
