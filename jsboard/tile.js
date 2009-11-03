function maketile(name, url) {
    return {
        name: name,
        url: url, 
        element: function() {
            return $("#" + name);
        },
        html: maketilehtml(name)
    };
}

function maketilehtml(name) {
     return "\
    <div class=\"scoretile\" id=\"" + name + "\"> \
    <div class=\"title\">" + name + "</div> \
    <div class=\"pegs\"> \
    <div class=\"peg peg1\"></div> \
    <div class=\"peg peg2\"></div> \
    <div class=\"peg peg3\"></div> \
    <div class=\"peg peg4\"></div> \
    <div class=\"peg peg5\"></div> \
    <div class=\"peg peg6\"></div> \
    <div class=\"peg peg7\"></div> \
    <div class=\"peg peg8\"></div> \
    <div class=\"peg peg9\"></div> \
    <div class=\"peg peg10\"></div> \
    <div class=\"peg peg11\"></div> \
    </div> \
    <div class=\"score\"></div> \
    <div class=\"status\"></div> \
    <div class=\"since\"></div> \
    </div> \
    ";
}