ODULE = scoreboard
PROD = src/java/core
PROV = src/java/providers
TEST = src/java/test
LIB = lib/run
CP = lib/run/bc/\*:lib/run/boost/\*:lib/run/freetts/\*:lib/run/jna/\*:lib/run/scripting/\*:lib/test/\*:lib/providers/cruise/\*:lib/providers/hudson/\*
CP_PROD = ${CP}:${PROD_CLS}
CP_PROV = ${CP_PROD}:${PROV_CLS}
CP_TEST = ${CP_PROV}:${TEST_CLS}
GEN = gen
ETC = etc
PROD_CLS = gen/prod/classes
PROV_CLS = gen/provider/classes
ALL_CLS = gen/all/classes
TEST_CLS = gen/test/classes
DIST = gen/dist
JAR = ${DIST}/${MODULE}.jar
TAR = ${DIST}/${MODULE}-${VERSION}.tar
HUDSON_PLUGIN = ${DIST}/${MODULE}-hudson.hpi
CRUISE_PLUGIN = ${DIST}/${MODULE}-cruise.jar
VERSION = 0.93
MANIFEST = ${ETC}/MANIFEST.MF
DIST_MANIFEST = ${GEN}/MANIFEST.MF
TAR_IMAGE = ${GEN}/image/scoreboard-${VERSION}

.PHONY: clean

default: test dist

compile: clean ${PROD_CLS} ${TEST_CLS} ${PROV_CLS} ${ALL_CLS}
	find ${PROD} -name "*.scala"  -o -name "*.java" | xargs -s 30000 fsc -classpath ${CP} -d ${PROD_CLS} && \
	find ${PROD} -name "*.java" | xargs -s 30000 javac -classpath ${CP} -d ${PROD_CLS} && \
	find ${PROV} -name "*.scala"  -o -name "*.java" | xargs -s 30000 fsc -classpath ${CP_PROD} -d ${PROV_CLS} && \
	find ${PROV} -name "*.java" | xargs -s 30000 javac -classpath ${CP_PROD} -d ${PROV_CLS} && \
	find ${TEST} -name "*.scala" -o -name "*.java" | xargs -s 30000 fsc -classpath ${CP_PROV} -d ${TEST_CLS} && \
	find ${TEST} -name "*.java" | xargs -s 30000 javac -classpath ${CP_PROV} -d ${TEST_CLS} && \
	./etc/copy-resources ${PROD} ${PROD_CLS} && \
	./etc/copy-resources ${PROV} ${PROV_CLS} && \
	./etc/copy-resources ${TEST} ${TEST_CLS} && \
	cp -r ${PROD_CLS} ${PROV_CLS} ${ALL_CLS}


test: compile
	(cd ${TEST} > /dev/null && find * -name \*Test.java | sed -e s/.java// | sed -e s:/:.:g) | xargs  \
	java -cp ${CP_TEST} org.junit.runner.JUnitCore 

${HUDSON_PLUGIN}: ${JAR} ${GEN}/tmp ${GEN}/image-hudson
	mkdir -p ${GEN}/image-hudson/WEB-INF/classes/META-INF/services && \
	mkdir -p ${GEN}/image-hudson/WEB-INF/lib && \
	cp ${JAR} lib/run/boost/boost.jar ${GEN}/image-hudson/WEB-INF/lib && \
	cp ${ETC}/plugins/hudson/MANIFEST.MF ${GEN}/image-hudson/WEB-INF/classes/META-INF && \
	cp ${ETC}/plugins/hudson/hudson.plugin ${GEN}/image-hudson/WEB-INF/classes/META-INF/services && \
	cp -r ${ETC}/plugins/hudson/resources/. ${GEN}/image-hudson/WEB-INF/classes && \
	cp -r ${PROV_CLS} ${GEN}/image-hudson/WEB-INF/classes && \
	cp -r ${ETC}/plugins/hudson/webapp ${GEN}/image-hudson && \
	jar cfm ${HUDSON_PLUGIN} ${ETC}/plugins/cruise/MANIFEST.MF -C ${GEN}/image-hudson .

${CRUISE_PLUGIN}: ${JAR} ${GEN}/tmp
	(cd ${GEN}/tmp && jar xf ../../lib/run/boost/boost.jar) &&
	jar cfm ${CRUISE_PLUGIN} ${ETC}/plugins/cruise/MANIFEST.MF -C ${ALL_CLS} . -C ${GEN}/tmp .

${JAR}: compile ${DIST_MANIFEST} ${DIST}
	jar cfm ${JAR} ${DIST_MANIFEST} -C ${PROD_CLS} .

${TAR}: ${JAR} ${HUDSON_PLUGIN} ${CRUISE_PLUGIN} ${TAR_IMAGE} ${TAR_IMAGE}/lib ${TAR_IMAGE}/plugins
	cp -r bin ${TAR_IMAGE} && \
	rm ${TAR_IMAGE}/bin/scoreboard-dev && \
	cp ${JAR} lib/run/*/*.jar ${TAR_IMAGE}/lib && \
	cp ${HUDSON_PLUGIN} ${CRUISE_PLUGIN} ${TAR_IMAGE}/plugins && \
	cp COPYING FEATURES README TASKS etc/config/config-example.js ${TAR_IMAGE} && \
	cp -r ${ETC}/licenses ${TAR_IMAGE} && \
	tar cfz ${TAR} -C ${GEN}/image .

dist: clean ${TAR}

${DIST_MANIFEST}: ${GEN}
	sed -e 's/VERSION/${VERSION}/' ${MANIFEST} > ${DIST_MANIFEST}

repl: compile
	scala -classpath ${CP}:${PROD_CLS}:${TEST_CLS}

size: 
	find ${PROD} -name "*.java" | xargs wc | sort -n && \
	find ${PROD} -name "*.scala" | xargs wc | sort -n

simian:
	echo "implement me"

${GEN} ${GEN}/tmp ${PROV_CLS} ${PROD_CLS} ${TEST_CLS} ${ALL_CLS} ${DIST} ${LIB} ${TAR_IMAGE} ${TAR_IMAGE}/lib ${TAR_IMAGE}/plugins ${GEN}/image-hudson:
	mkdir -p $@

clean:
	rm -rf ${GEN}; find . -name "*~" -o -name "*.core" -print0 | xargs -0 rm
