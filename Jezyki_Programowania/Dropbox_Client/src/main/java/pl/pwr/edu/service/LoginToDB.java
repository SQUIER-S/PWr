package pl.pwr.edu.service;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;

import java.util.Locale;

/**
 * Created by SQUIER on 2016-01-14.
 */
public class LoginToDB {

    private static final String APP_KEY = "c4dnrnvtn5ep23i";
    private static final String APP_SECRET = "xe8dxapiuwu313b";

    private LoginToDB() {}

    public static DbxWebAuthNoRedirect getWebAuth() {
        DbxAppInfo dbxAppInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig("dbClient", Locale.getDefault().toString());
        return new DbxWebAuthNoRedirect(config, dbxAppInfo);
    }

}
