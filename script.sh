#!/usr/bin/env bash

curl -sO https://raw.githubusercontent.com/crazyuploader/Bash/master/build_droid.sh
bash build_droid.sh
ERROR_CODE="$?"
rm build_droid.sh
if [[ "${ERROR_CODE}" != "0" ]]; then
    exit 1
fi
