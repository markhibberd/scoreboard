var SECONDS = 1000;
var MINUTES = 60 * SECONDS;
var HOURS = 60 * MINUTES;
var DAYS = 24 * HOURS;
var WEEKS = 7 * DAYS;
var MONTHS = 30 * DAYS;
var YEARS = 365 * DAYS;

function s(start, unit, message) {
    return {
        start: start,
        unit: unit, 
        message: message
    };
}

var slices = new Array(
    s(0, SECONDS, "just happened"),
    s(1, SECONDS, "1 second"),
    s(2, SECONDS, "%d seconds"),
    s(40, SECONDS, "almost a minute"),
    s(1, MINUTES, "1 minute"),
    s(2, MINUTES, "%d minutes"),
    s(20, MINUTES, "half an hour"),
    s(40, MINUTES, "almost an hour"),
    s(1, HOURS, "1 hour"),
    s(2, HOURS, "%d hours"),
    s(4, HOURS, "half a day"),
    s(8, HOURS, "almost a day"),
    s(1, DAYS, "1 day"),
    s(2, DAYS, "%d days"),
    s(5, DAYS, "almost a week"),
    s(1, WEEKS, "1 week"),
    s(2, WEEKS, "%d weeks"),
    s(4, WEEKS, "almost a month"),
    s(1, MONTHS, "1 month"),
    s(2, MONTHS, "%d months"),
    s(6, MONTHS, "half a year"),
    s(7, MONTHS, "over half a year"),
    s(9, MONTHS, "almost a year"),
    s(1, YEARS, "1 year"),
    s(2, YEARS, "%d years")
 );

function findslice(duration) {
    var selected = slices[0];
    for (var i = 0; i < slices.length; ++i) {
        if (past(duration, slices[i])) return selected;
        selected = slices[i];
    }
    return selected;
}

function past(duration, slice) {
    var start = slice.start;
    var unit = slice.unit;
    var reference = start * unit;
    return reference > duration;
}

function roughly(duration) {
    var slice = findslice(duration);
    var msg = slice.message;
    var unit = slice.unit;
    var value = parseInt(duration / unit);
    return msg.replace(/%d/i, value);
}