threadpool.threads(2);

hudson = "http://localhost:8080/score/";
build("moo", hudson + "moo");

