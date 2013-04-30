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
	git checkout master && \
        git pull origin master && \
	(cd gen && git clone git://github.com/markhibberd/argonaut.git) && \
	(cd gen/argonaut && ./sbt '; ++2.10.1 ; doc') && \
	rsync -aH gen/argonaut/target/scala-2.10/api/* scaladocs/. && \
	rm -rf gen && \
	git add scaladocs && \
	git commit -m "Latest docs." 
	git push origin master
	git checkout gh-pages && \
	git merge origin/master && \
	git push origin gh-pages  && \
	git checkout master
