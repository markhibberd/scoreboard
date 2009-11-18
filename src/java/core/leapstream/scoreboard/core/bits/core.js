function build(name, url) {
    //var m = typeof(mandatory) != 'undefined' ? mandatory : true;
    var b = builds.nu(name, [url]);
    var p = wirer.nu(name, b, true);
    board.add(p);
}

function status(name, url) {
//    var m = typeof(mandatory) != 'undefined' ? mandatory : true;
    var s = stati.nu(name, [url]);
    var p = wirer.nu(name, s, true);
    board.add(p);
}

function image(interval, url) {
//    var m = typeof(mandatory) != 'undefined' ? mandatory : false;
    var i = images.nu(interval, [url]);
    var p = wirer.nu("image", i, false);
    board.add(p);
}
