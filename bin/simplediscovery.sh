#!/bin/bash

net_cloud='cloud'
client_num=3

function createNet() {
    docker network ls | awk '{print $2}' | grep ${net_cloud}
    if [[ $? -eq 1 ]]; then
        echo "create ${net_cloud} network"
        docker network create ${net_cloud}
    fi
}

function install() {
    createNet

    echo "create a eureka server and some eureka clients"
    docker run -d -p 8000:8000 --net=${net_cloud} --name=eureka-server eureka-server
    echo "create eureka server success"

    for (( i = 0; i < ${client_num}; ++i )); do
        docker run -d --net=${net_cloud} --name=client-node${i} eureka-client
        echo "create eureka clients success"
    done

    docker run -d -p 9100:9100 --net=${net_cloud} --name=ribbon ribbon
    docker run -d -p 9200:9200 --net=${net_cloud} --name=feign feign
    docker run -d -p 9300:9300 --net=${net_cloud} --name=zuul zuul
}

function clear() {
    for (( i = 0; i < ${client_num}; ++i )); do
        docker kill client-node${i}
        docker rm client-node${i}
    done
    docker kill ribbon
    docker rm ribbon
    docker kill eureka-server
    docker rm eureka-server
    docker kill feign
    docker rm feign
    docker kill zuul
    docker rm zuul

}
function usage() {
    echo "Operation Manual: $0 [-h] [-i|install] [-c|clear]"
    echo "  $0 -i       create eureka server and some clients, expose 8000 port"
    echo "  $0 -c       clear docker and network"
}

if [[ $# -eq 0 ]]; then
    usage
    exit 0
fi
while getopts "ic" opt; do
    case ${opt} in
        i)
            install
            echo "create eureka server client ribbon success"
            echo "server port 8000, ribbon port 9100, feign port 9200"
            ;;
        c)
            clear
            ;;
    esac
done