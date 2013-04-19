package edu.makoto.multilingual;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WebApp;

public class CustomWebAppInit implements org.zkoss.zk.ui.util.WebAppInit {
	
	/*
	 * The of this is very important , because it will be reconigzed by your browser
	 * In case that you need diferent labels for a same language for example;
	 * en_US --> USA
	 * en_GB --> UK
	 * You have to add other CustomerLabel Loader and change the name of the first parameter.
	 * Example :
	 *  .....("i3-label-en_US","en_US")
	 *  .....("i3-label-en_GB","en_US")
	 *  the second parameter is used for compare when ZK try to load labels (en,EN,en_US)
	 *  
	 */

    public void init(WebApp wapp) throws Exception {    	        
    	Labels.register(new CustomLabelLoader("i3-label_en","en"));
        Labels.register(new CustomLabelLoader("i3-label_es","es")); 
    }
}
