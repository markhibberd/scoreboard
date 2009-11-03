function layouttile(tile, x, y, w, h) {
        var unit = parseInt(w / 5);
        var half = parseInt(unit / 2);
        var peg = parseInt(unit * 3 / 11);


        var title = tile.children(".title");
        var pegtainer = tile.children(".pegs");
        var score = tile.children(".score");
        var status = tile.children(".status");
        var since = tile.children(".since");

        /* layout */
        box(tile, x, y, w, h);            
        box(title, 0, 0, w, unit);
        // XXX center number, could be box(score, half, unit, w - half, unit * 3), font makes big diff
        box(score, 0, unit, w, unit * 3);
        box(pegtainer, 0, unit, half, unit * 3);
        pegtainer.children(".peg").each(function(i) {
                box($(this), 0, (i * peg), half - 2, peg);
        });
        box(status, 0, unit * 4, w, unit);
        box(since, 0, unit * 5, w, unit);


        /* fonts */
        fontsize(title, unit / 2, unit);
        fontsize(score, unit * 3, unit * 3);
        fontsize(status, unit / 2, unit);
        fontsize(since, unit / 2, unit);
}

function box(el, x, y, w, h) {
        el.css("left", x)
        el.css("top", y)
        el.width(w);
        el.height(h);
}

function fontsize(el, height, container) {
    el.css("font-size", height);
    el.css("line-height", container + "px");
    el.css("vertical-align", "middle");
}


