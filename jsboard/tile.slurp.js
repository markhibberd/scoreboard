
// XXX this whole slurper is nasty, need to sort out, what to actually do here, server side?

function slurp(tile) {
    var element = tile.element();
    var pegtainer = element.children(".pegs");
    var score = element.children(".score");
    var status = element.children(".status");
    var since = element.children(".since");

    $.getJSON(tile.url,
              function(data){
                  for (var i = 0; i < data.history.length && i < 11; ++i) {
                      var j = i + 1;
                      var peg = pegtainer.children(".peg" + j);
                      pokepeg(peg, data.history[i].result);
                  }
                  pokescore(score, data.history);
                  status.text(data.status.is);
                  var pretty = roughly(data.timestamp - data.status.since);
                  since.text(pretty);
              });
}

function pokescore(score, history) {
    score.removeClass("good");
    score.removeClass("unknown");
    score.removeClass("broken");
    var run = calcscore(history);
    score.text(run);
    if (history.length <= 0) {
        score.addClass("unknown");
        return;
    }
    var result = history[0].result;
    if (result == "SUCCESS") score.addClass("good");
    else if (result = "FAILURE") score.addClass("broken");
    else score.addClass("unknown");
}

function pokepeg(peg, result) {
    peg.removeClass("good");
    peg.removeClass("unknown");
    peg.removeClass("broken");
    if (result == "SUCCESS") peg.addClass("good");
    else if (result = "FAILURE") peg.addClass("broken");
    else peg.addClass("unknown");
}


function calcscore(history) {
    if (history.length <= 0) return 0;
    var start =  history[0].result;
    var run = 0;
    while (run < history.length &&
           run < 11 &&
           start == history[run].result) {
        ++run;
    }
    return run;
}