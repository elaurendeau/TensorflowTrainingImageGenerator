package util

import java.util.stream.Collectors

fun <A, B> List<A>.pmap(f: (A) -> B): List<B> = parallelStream().map { f(it) }.collect(Collectors.toList())
