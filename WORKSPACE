load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# Scala

http_archive(
    name = "bazel_skylib",
    sha256 = "b8a1527901774180afc798aeb28c4634bdccf19c4d98e7bdd1ce79d1fe9aaad7",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/1.4.1/bazel-skylib-1.4.1.tar.gz",
        "https://github.com/bazelbuild/bazel-skylib/releases/download/1.4.1/bazel-skylib-1.4.1.tar.gz",
    ],
)

http_archive(
    name = "io_bazel_rules_scala",
    sha256 = "cc590e644b2d5c6a87344af5e2c683017fdc85516d9d64b37f15d33badf2e84c",
    strip_prefix = "rules_scala-6.1.0",
    url = "https://github.com/bazelbuild/rules_scala/releases/download/v6.1.0/rules_scala-v6.1.0.tar.gz",
)

load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

scala_config(scala_version = "3.1.0")

load(
    "@io_bazel_rules_scala//scala:scala.bzl",
    "rules_scala_setup",
    "rules_scala_toolchain_deps_repositories",
)

rules_scala_setup()

rules_scala_toolchain_deps_repositories(fetch_sources = True)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")

scala_register_toolchains()
