function build(name, url) {
    var b = builds.nu(name, [url]);
    pylons.mandatory(b);
}
function status(name, url) {
    var s = stati.nu(name, [url]);
    pylons.mandatory(s);
}
function image(interval, url) {
    var i = images.nu(interval, [url]);
    pylons.optional(i);
}
