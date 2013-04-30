MFLAGS = -s
MAKEFLAGS = ${MFLAGS}

.PHONY: dev publish

default: dev

dev:
	jekyll --auto --serve

publish:
	git checkout gh-pages && \
	git merge origin/master && \
	git push origin gh-pages && \
	git checkout master
