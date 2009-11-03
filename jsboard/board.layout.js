/* viewport hack, viewport size with some buffer */
window.viewport = {
    height: function() { 
        return $(window).height() - 10; 
    },
    
    width: function() {
        return $(window).width() - 10;
    }
};

var aspect = {
    width: 5,
    height: 6
};

function layoutboard() {
    var tile = $(".scoretile");
    var size = tile.size();
    var layout = determinelayout(size);
    var offset = layout.offset;
    tile.each(function(i) {
         var x = parseInt(i % layout.x);
         var y = parseInt(i / layout.x);
         var xx = offset.x + x * layout.width;
         var yy = offset.y + y * layout.height;
         // XXX magic num is margin, need to parametize, and enable border shrinking, etc...
         layouttile($(this), xx + 2, yy + 2, layout.width - 4, layout.height - 4);
    });
}  

function determinelayout(cells) {
    var layouts = permutations(cells);
    var tiles = sized(layouts);
    return biggest(layouts, tiles);
}


function permutations(cells) {
    var flt = Math.sqrt(cells - 1) + 1;    
    var max = parseInt(flt);
    var all = max * 2;
    var combos = new Array();
    for (var i = 0; i < all; ++i) {
        var h = i + 1;
        var w = (cells - 1) / h + 1;
        combos[2 * i] = size(w, h);
        combos[2 * i + 1] = size(w, h);
    }    
    return combos;
}

function sized(layouts) {
    var result = new Array(layouts.length);
    for (var i = 0; i < result.length; ++i) {
        var h = viewport.height() / layouts[i].height;
        var w = (h * aspect.width) / aspect.height;
        if (w * layouts[i].width > viewport.width()) {
            w = viewport.width() / layouts[i].width;
            h = (w * aspect.height) / aspect.width;
        }
        result[i] = size(w, h);
    }
    return result;
}

// XXX insanity, fix this shite.
function biggest(layouts, tiles) {
    var result = {
        offset: {
            x: 0,
            y: 0
        },
        x: 0,
        y: 0,
        width: 0,
        height: 0
    };
    for (var i = 0; i < layouts.length; ++i) {
        if (tiles[i].width > result.width) {
            result.x = layouts[i].width;
            result.y = layouts[i].height;
            result.width = tiles[i].width;
            result.height = tiles[i].height;
        }
    }
    result.offset.x = parseInt((viewport.width() - result.x * result.width) / 2) + 5;
    result.offset.y = parseInt((viewport.height() - result.y * result.height) / 2) + 5;
    return result;
}

function size(w, h) {
    return {
        width: parseInt(w),
        height: parseInt(h)
    };
}
