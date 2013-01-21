package com.kokakiwi.mclauncher.ui.boozaa;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import com.kokakiwi.mclauncher.api.LauncherAPI;
import com.kokakiwi.mclauncher.api.ui.Page;
import com.kokakiwi.mclauncher.api.ui.Theme;


public class BoozaaTheme implements Theme {

	private LauncherAPI       api;
    
    private BoozaaLoginPage   loginPage;
    private BoozaaLoadingPage loadingPage;
    
    private Image             background = null;
    
    public void onLoad(LauncherAPI api)
    {
        this.api = api;
        
        loginPage = new BoozaaLoginPage();
        loadingPage = new BoozaaLoadingPage();
    }
    
    public List<Page> getPages()
    {
        final List<Page> pages = new ArrayList<Page>();
        
        pages.add(loginPage);
        pages.add(loadingPage);
        
        return pages;
    }
    
    public Dimension getDimension()
    {
        return new Dimension(854, 480);
    }
    
    public Image getBackground()
    {
        if (background == null)
        {
            try
            {
                background = ImageIO.read(
                        BoozaaTheme.class.getResourceAsStream("/"
                                + api.getConfig().getString(
                                        "theme.simple.background")))
                        .getScaledInstance(32, 32, 16);
            }
            catch (final IOException e)
            {
                e.printStackTrace();
            }
        }
        
        return background;
    }
    
	
	
}
