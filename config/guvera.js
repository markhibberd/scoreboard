hudson = "http://weener:8080/score/";

bs = ["guvera-app", "preregistration"];
ss = ["mercury", "venus"];

for each(x in bs) build(x, hudson + x);
for each(x in ss) status(x, hudson + x);

image(300000, "http://www.bom.gov.au/radar/IDR662.gif");
