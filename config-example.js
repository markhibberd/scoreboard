
/*
API
========================================


// set number of threads in thread pool
threadpool.threads(20);

// get number of threads in thread pool
threadpool.threads();

// add a a mandatory pylon
pylons.mandatory(pylon);

// add a an optional pylon
pylons.optional(pylon);

// create a new status pylon
var status = stati.nu(name, url);

// create a new score pylon
var status = builds.nu(name, url);

// create a new rotating image pylon
var status = images.nu(time, [urls]);

// create a new static image pylon
var status = images.nu(url);


// convenience apis:
// create and add a mandatory build pylon
build(name, url);

// create and add a mandatory status pylon
status(name, url);

// create and add an optional refreshing image, i.e. bom
image(name, url);

*/
