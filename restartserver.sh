#!/bin/bash
npid="/root/Protomapper-Serve/RUNNING_PID"
if [ -e "$npid" ]
then
pid=`cat /root/Protomapper-Serve/RUNNING_PID`
kill $pid
fi

cd /root/Protomapper-Serve && nohup play "start 80" &
cd -
