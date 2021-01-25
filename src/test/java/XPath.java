public class XPath {
    String myUrl = "http://computer-database.gatling.io/computers";
    String name = "//*[@id=\"name\"]";
    String compName = "Packard bell";
    String company = "//div[@class='input']/descendant::option[text()='Netronics']";
    String create = "//div[@class='actions']/descendant::input[@value='Create this computer']";
    String successfulMessage = "//div[@class=\"alert-message warning\"]";
    String rightTextMessage = "Done ! Computer Packard bell has been created";
    String foundCompName = "//div[@id='actions']/descendant::input[@id='searchbox']";
    String filterByName = "//div[@id='actions']/descendant::input[@value='Filter by name']";
    String checkCompName = "//*[@class=\"computers zebra-striped\"]";
}
