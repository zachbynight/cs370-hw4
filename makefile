MAIN_DIR=main/java/
MAIN_FILES=${MAIN_DIR}BoundedBuffer.java
TESTING_DIR=test/java/
TESTING_FILE=${TESTING_DIR}Main.java
TESTING_CLASS=test.java.Main

test: build
	javac ${TESTING_FILE}
	clear
	java ${TESTING_CLASS}

build:
	javac ${MAIN_FILES}