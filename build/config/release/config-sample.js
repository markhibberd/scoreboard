hudson = "http://www.leapstream.com.au/products/scoreboard/samples/hudson/";
cruise = "http://www.leapstream.com.au/products/scoreboard/samples/cruise/";

build("hornet", hudson + "hudson-hornet");
build("evil", hudson + "hudson-evil");
build("cruiser", cruise + "cruiser");
status("status", hudson + "hudson-status");

image(300000, "http://www.bom.gov.au/radar/IDR662.gif");
