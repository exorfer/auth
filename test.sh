#!/usr/bin/env bash
./build.sh
COUNT_ALL=0
COUNT_SUC=0

function test {
    MSG=$1; shift
    EXPECTED=$1; shift

    echo
    echo ${MSG}
    ./run.sh "$@"
        RES=$?
    let COUNT_ALL++
    if [ $RES -eq $EXPECTED ]; then
            echo Test passed Expected $EXPECTED Actual ${RES}
            let "COUNT_SUC = $COUNT_SUC + 1"
        else
            echo Test failed. Expected $EXPECTED Actual ${RES}
        fi
}

test 1 0 -login foo@example.com -pass 123456
#test 2 0 -pass 123456 -login foo@example.com
test 3 1
test 4 1 -login foo@example.com -pass 123456 -param
test 5 1 -pass 123456
test 6 1 -h
test 7 1 -login foo@example.com
test 8 2 -login zzz -pass qwerty
test 9 3 -login xxx@example.com -pass 123456
#test 10 4 -login foo@example.com -pass abc

if [ $COUNT_ALL -eq $COUNT_SUC ]; then
    echo All $COUNT_ALL tests passed
    exit 0
else
    echo $COUNT_SUC of $COUNT_ALL test passed
exit 1
fi
