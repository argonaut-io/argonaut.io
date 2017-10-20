MFLAGS = -s
MAKEFLAGS = ${MFLAGS}

.PHONY: clean dev publish publish-noscaladoc

default: dev

clean:
	rm -rf gen

dev:
	jekyll serve

gen scaladocs:
	mkdir -p $@

publish: clean gen scaladocs
	git checkout master
	git pull origin master
	(cd gen && git clone git://github.com/argonaut-io/argonaut.git)
	(cd gen/argonaut && sbt '; ++2.11.11 ; doc')
	rsync -aH gen/argonaut/argonaut/jvm/target/scala-2.11/api/* scaladocs/.
	rm -rf gen
	git add scaladocs
	git commit -m "Latest docs." || true
	git push origin master || true
	git checkout gh-pages
	git merge origin/master
	git push origin gh-pages
	git checkout master

publish-noscaladoc: clean
	git checkout gh-pages
	git merge origin/master
	git push origin gh-pages
	git checkout master
