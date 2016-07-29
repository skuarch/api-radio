#!/bin/bash

export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8
JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8
java -jar -Dspring.profiles.active=production api-radio.jar &
