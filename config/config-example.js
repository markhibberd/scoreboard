
/*
API
========================================

/---------   General Options ----------------

// set number of threads in thread pool
threadpool.threads(20);

// get number of threads in thread pool
threadpool.threads();

// set window title
window.title("my title");

// set to fullscreen on load
window.fullscreen();

/---------   Low-Level Creation of Pylons ----------------

// create a new status pylon
var tile = stati.nu(name, url);

// create a new score pylon
var tile = builds.nu(name, url);

// create a new score pylon, overriding poll period in millis (20 seconds in this case)
var tile = builds.nu(name, url, 20 x 1000);

// create a new rotating image pylon
var tile = images.nu(time, [urls]);

// create a new static image pylon
var tile = images.nu(url);

// create a pylon from a tile.
var pylon = wirer.nu(name, tile, mandatory);

// add pylon to board
board.add(pylon);

/--------    Simple api....

// create and add a mandatory build pylon
build(name, url);

// create and add a mandatory status pylon
status(name, url);

// create and add an optional refreshing image, i.e. bom
image(name, url);

*/

window.title("demo");

threadpool.threads(2);

hudson = "http://www.leapstream.com.au/products/scoreboard/samples/hudson/";
cruise = "http://www.leapstream.com.au/products/scoreboard/samples/cruise/";

build("hornet", hudson + "hudson-hornet", 20000);
build("evil", hudson + "hudson-evil");
build("cruiser", cruise + "cruiser");
status("status", hudson + "hudson-status");

image(300000, "http://www.bom.gov.au/radar/IDR662.gif");


