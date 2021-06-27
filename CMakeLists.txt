cmake_minimum_required(VERSION 3.19)
project(Programmieren C)

set(CMAKE_C_STANDARD 99)

add_executable(helloworld
        src/c/helloworld/helloworld.c)

add_executable(euclid
        src/c/euclid/euclid.c)

add_executable(remove
        src/c/remove/remove.c)

add_executable(strqueue
        src/c/strqueue/strqueue_main.c src/c/strqueue/strqueue.c src/c/strqueue/reverse.c)
