MAIN_DIR=main/java/
MAIN_FILES=${MAIN_DIR}Agent.java ${MAIN_DIR}BoundedBuffer.java ${MAIN_DIR}Consumer.java ${MAIN_DIR}Producer.java ${MAIN_DIR}ProducerConsumer.java
MAIN_CLASS=main.java.ProducerConsumer
TESTING_DIR=test/java/
TESTING_FILE=${TESTING_DIR}Main.java
TESTING_CLASS=test.java.Main

test: build
	javac ${TESTING_FILE}
	clear
	java ${TESTING_CLASS}

build:
	javac ${MAIN_FILES}

clean:
	find . -name "*.class" -type f -delete