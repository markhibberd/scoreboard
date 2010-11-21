// FIX this is pretty horrible... implement something that will just accept the data

function build(name, url, poll) {
    var w = poll || 10000;
    var b = builds.nu(name, [url], w);
    var p = wirer.nu(name, b, true);
    board.add(p);
}

function status(name, url, poll) {
    var w = poll || 10000;
    var s = stati.nu(name, [url], w);
    var p = wirer.nu(name, s, true);
    board.add(p);
}

function image(interval, url, poll) {
    var i = images.nu(interval, [url]);
    var p = wirer.nu("image", i, false);
    board.add(p);
}
