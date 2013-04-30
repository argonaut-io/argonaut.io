MFLAGS = -s
MAKEFLAGS = ${MFLAGS}

.PHONY: dev publish

default: dev

dev:
	jekyll --auto --serve

gen scaladocs
	mkdir -p $@

publish: gen scaladocs
	(cd gen && git clone git://github.com/markhibberd/argonaut.git) && \
	(cd gen/argonaut && ./sbt '; ++2.10.1 ; doc') && \
	rsync -aH argonaut/target/scala-2.10/api/* scaladocs/. && \
	git checkout gh-pages && \
	git merge origin/master && \
	git push origin gh-pages && \
	git checkout master
