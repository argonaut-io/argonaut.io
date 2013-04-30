MFLAGS = -s
MAKEFLAGS = ${MFLAGS}

.PHONY: clean dev publish

default: dev

clean:
	rm -rf gen

dev:
	jekyll --auto --serve

gen scaladocs:
	mkdir -p $@

publish: clean gen scaladocs
	(cd gen && git clone git://github.com/markhibberd/argonaut.git) && \
	(cd gen/argonaut && ./sbt '; ++2.10.1 ; doc') && \
	rsync -aH gen/argonaut/target/scala-2.10/api/* scaladocs/. && \
	git checkout gh-pages && \
	git merge origin/master && \
	git push origin gh-pages 
	rm -rf gen
	git checkout master
