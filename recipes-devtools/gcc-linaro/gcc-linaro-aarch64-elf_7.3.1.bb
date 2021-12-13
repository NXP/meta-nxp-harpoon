#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

require recipes-devtools/gcc-linaro/gcc-linaro.inc

TC_NAME = "gcc-linaro-7.3.1-2018.05-x86_64_aarch64-elf"

SRC_URI = "https://releases.linaro.org/components/toolchain/binaries/7.3-2018.05/aarch64-elf/${TC_NAME}.tar.xz"

SRC_URI[md5sum] = "89b6b05c557243fb5d029f3916023121"

