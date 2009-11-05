
// Thread management example....
// threadpool.threads(20);

hudson = "http://hudson:10080/score/";
geekscape = "http://boost:boost@geekscape.org/dashboard/tab/score/boost";
all = ["boost", "fist", "hammer", "juggernaut", "scoreboard", "shampoo", "web", "penetrate", ];
for each(x in all) build(x, hudson + x);
build("boost@geekscape", geekscape);
image(300000, "http://www.bom.gov.au/radar/IDR662.gif");