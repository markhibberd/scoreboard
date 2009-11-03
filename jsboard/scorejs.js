function plonk(name, url) {
    var tile = maketile(name, url);
    $("body").append(tile.html);   
    slurp(tile);
    setInterval(function() {
            slurp(tile);
        }, 10000);

}

$(document).ready(function() { 
        plonk("boost", "boost.json");
        plonk("fido", "boost.json");
        plonk("fella", "boost.json");
        plonk("killa", "killa.json");
        layoutboard();
        $(window).resize(function(){
                layoutboard();
        });
});

