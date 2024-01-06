dev:
	make -C app run

start: dev

setup:
	make -C wrapper --gradle-version 8.3

install:
	make -C installDist

clean:
	make -C app clean

build:
	make -C app build

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

.PHONY: build