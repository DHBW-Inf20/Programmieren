cmake_minimum_required(VERSION 3.21)
project(Programmieren C)

set(CMAKE_C_STANDARD 17)

add_executable(helloworld
        src-c/semester2/helloworld/helloworld.c)

add_executable(euclid
        src-c/semester2/euclid/euclid.c)

add_executable(remove
        src-c/semester2/remove/remove.c)

add_executable(strqueue
        src-c/semester2/strqueue/strqueue_main.c src-c/semester2/strqueue/strqueue.c src-c/semester2/strqueue/reverse.c)

add_executable(strcat
        src-c/semester2/strcat/strcat.c)

add_executable(strin
        src-c/semester2/strin/strin.c)

add_executable(map
        src-c/semester2/map/map.c)

add_executable(tree
        src-c/semester2/tree/tree_main.c src-c/semester2/tree/tree.c)

add_executable(tree_memcheck
        src-c/semester2/tree/tree_memcheck.c src-c/semester2/tree/tree.c)
