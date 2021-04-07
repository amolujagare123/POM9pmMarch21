package UITesting.Clients;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Menu;
import pages.client.AddClient;
import util.DoLogin;

public class AddClientTest extends DoLogin {

    AddClient addClient;

    @BeforeClass
    public void gotoAddClientPage()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();
        addClient = new AddClient(driver);
    }

    @Test
    public void checkBoxActiveSelectionCheck() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = addClient.checkBoxActive.isSelected(); // true /false
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,
                "active check box is not selected");
    }


}
