hudson = "http://www.leapstream.com.au/products/scoreboard/samples/hudson/";

build("bug", hudson + "hudson-hornet", 10000);

status("status", hudson + "hudson-status");
