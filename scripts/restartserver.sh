#!/bin/bash
approot=$(dirname $(readlink -f "$0"))/..
npid=$approot/RUNNING_PID

if [ -e "$npid" ]
then
pid=`cat $npid`
kill $pid
fi

cd approot && nohup play "start 80" &
cd -
