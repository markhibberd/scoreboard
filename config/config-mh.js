
threadpool.threads(2);

hudson = "http://localhost:8080/score/";

build("play", hudson + "play");
build("green", hudson + "green");
build("red", hudson + "red");
build("filler", hudson + "green");
